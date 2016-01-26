package com.interview.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class StableMatching {
	public static void main(String[] args) {
		int arr[][] = {{4,5,6,7},
				{4,5,6,7},
				{4,5,6,7},
				{4,5,6,7},
				{3,2,1,0},
				{2,3,1,0},
				{0,1,2,3},
				{0,2,3,1}};

		solve(arr);
	}

	private static void solve(int[][] arr) {//O(n^3) implementation
		// TODO Auto-generated method stub
		Queue<Integer> man = new LinkedList<Integer>();
		man.add(1);
		man.add(3);
		man.add(0);
		man.add(2);
       
		boolean woman [] = new boolean[4];
		int pref;

		HashMap<Integer,Integer> pair = new HashMap<>();

		while(!man.isEmpty()){
			int m = man.poll();

			for(int i = 0;i<4;i++){
				pref = arr[m][i];
				if(woman[pref-4]==false){
					woman[pref-4] = true;
                    pair.put(pref, m);
                    break;
				}
				else if(pair.containsKey(pref)){
					if(isHigher(arr,pref,m,pair.get(pref))){
						man.add(pair.get(pref));
						pair.remove(pref);
						pair.put(pref, m);	
						break;
					}
				}
			}
		}
		
		pair.forEach((k,v)-> System.out.println(v + " weds " + k));

	}

	private static boolean isHigher(int[][] arr, int w,int m, Integer m1) {
		// TODO Auto-generated method stub
		for(int i =0;i<4;i++){
			if(arr[w][i]==m){
				return true;
			}
			else if(arr[w][i]==m1){
				return false;
			}
		}
		
		return false;
	}
}
