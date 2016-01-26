package com.interview.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class CharFreq{
	char c;
	int freq;
	
	public CharFreq(char c,int freq){
		this.c = c;
		this.freq = freq;
	}	
}

public class NthMostFrequentCharacter {
	public static void main(String[] args) {
         String s = "wfxqwfxwqxfqwxfwqefxwefxewfxwefxwfqxq";
         solve(s,4);
    
	}

	private static void solve(String s,int k) {
		// TODO Auto-generated method stub
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i =0; i< s.length();i++){
			if(map.get(s.charAt(i))==null){
				map.put(s.charAt(i),1);
			}
			else
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		
		
		Iterator<Entry<Character, Integer>> i = map.entrySet().iterator();
		ArrayList<CharFreq> list = new ArrayList<>();
		while(i.hasNext()){
			Map.Entry<Character, Integer> pair = i.next();
			list.add(new CharFreq(pair.getKey(),pair.getValue()));
		}
		
		
		PriorityQueue<CharFreq> q = new PriorityQueue<>(k,new Comparator<CharFreq>(){

			@Override
			public int compare(CharFreq arg0, CharFreq arg1) {
				// TODO Auto-generated method stub
				return arg0.freq-arg1.freq;
			}
			
		});
		
		k = Math.min(k,list.size());
		for(int j = 0 ;j < k; j++){
			q.add(list.get(j));
		}
		for(int j = k ; j<list.size();j++){
			if(q.peek().freq<list.get(j).freq)
				{q.remove();
				q.add(list.get(j));
				}
		}
		
		q.forEach(x->System.out.println(x.c+" "+x.freq));
	}
}
