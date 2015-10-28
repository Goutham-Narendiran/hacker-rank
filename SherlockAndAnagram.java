package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class SherlockAndAnagram {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	HashMap<String,Integer> map ;
	String subStr;
	while(T-->0){
		map = new HashMap<>();
		String str = br.readLine();
		int len = str.length();
		for(int i=0;i<len;i++){
			for(int j = i+1;j<=len;j++){
				subStr = str.substring(i,j);
				char temp []=subStr.toCharArray();
				Arrays.sort(temp);
                 subStr = String.valueOf(temp);
				if(map.containsKey(subStr))
					map.put(subStr,map.get(subStr)+1);
				else
					map.put(subStr,1);       
			}
		}
			Iterator<Entry<String, Integer>> itr = map.entrySet().iterator();
			int ans = 0;
			while(itr.hasNext()){
			     Map.Entry<String, Integer> pair = (Entry<String, Integer>) itr.next();
			     ans+= pair.getValue()*(pair.getValue()-1)/2; // C(n,2) for calculating pairs
			}
			
			
			System.out.println(ans);
	}
}
}
