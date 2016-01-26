package com.interview.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;


class Hospital{
	int id;
	int residents;
	HashMap<Integer,Boolean> map;
	int pref[];
	public Hospital(int id,int arr[]){
		this.id = id;
		residents = 0;
		map = new HashMap<>();
		for(int i = 0; i < 12;i ++){
			map.put(i,false);
		}
		pref = arr;
	}

	public void incRes() throws Exception{
		if(residents<3)
			residents++;
		else
			throw new Exception();
	}

	public void decRes() throws Exception{
		if(residents>0)
			residents--;
		else
			throw new Exception();
	}

}

public class HospitalMatching {
	public static void main(String[] args) throws Exception {
		int hospitals[][] = {{0,1,2,3,4,5,6,7,8,9,10,11},
				{3,2,5,4,1,0,6,9,8,7,10,11},
				{0,1,2,3,4,5,6,7,8,9,10,11}};
		int residents[][] = {{0,1,2},
				{1,0,2},
				{0,1,2},
				{2,1,0},
				{1,2,0},
				{0,1,2},
				{0,1,2},
				{2,1,0},
				{1,2,0},
				{1,2,0},
				{0,1,2},
				{2,1,0}
		};

		solve(hospitals,residents);
	}

	private static void solve(int[][] hospitals, int[][] residents) throws Exception {
		// TODO Auto-generated method stub
		boolean res[] = {false,false,false,false,false,false,false,false,false,false,false,false};
		HashMap<Integer,Hospital> restohos = new HashMap<>();
		Queue<Hospital> queue = new LinkedList<>();
		for(int i = 0;i<3;i++){
			queue.add(new Hospital(i,hospitals[i]));
		}

		while(!queue.isEmpty()){
			Hospital h = queue.poll();
			int pref;
			for(int i = 0;i<12;i++){
				pref = h.pref[i];
				if(h.map.get(pref)==true)
					continue;
				if(res[pref]==false){
					h.incRes();
					h.map.put(pref, true);
					res[pref] = true;
					restohos.put(pref,h);
				}
				else{
					Hospital h1 = h;
					Hospital h2 = restohos.get(pref);
					if(isHigher(pref,residents,h1,h2)){
						h2.decRes();
						h2.map.put(pref, false);
						if(h2.residents<3)
							queue.add(h2);
						h1.incRes();
						h1.map.put(pref, true);
						restohos.put(pref,h1);
					}

				}

				if(h.residents==3)
					break;
			}
		}

		Iterator<Map.Entry<Integer, Hospital>> i = restohos.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Integer, Hospital> pair = (Entry<Integer, Hospital>) i.next();
			System.out.println("Resident "+pair.getKey()+"->"+"Hospital "+pair.getValue().id);
		}

	}

	private static boolean isHigher(int pref, int[][] residents, Hospital h1, Hospital h2) {
		// TODO Auto-generated method stub
		for(int i =0;i<3;i++){
			if(residents[pref][i]==h1.id)
				return true;
			if(residents[pref][i]==h2.id)
				return false;
		}

		return false;
	}
}
