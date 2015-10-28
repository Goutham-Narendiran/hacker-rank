package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramsPrinting {
	public static void main(String...args){
		String arr[] = {"cat","dog","tac","god"};
		HashMap<String,ArrayList<String>> map = new HashMap<>();
		for(int i =0;i<arr.length;i++)
		{
			char temp [] = arr[i].toCharArray();
			Arrays.sort(temp);
			if(map.containsKey(String.valueOf(temp))){
				ArrayList<String> list = map.get(String.valueOf(temp));
				list.add(arr[i]);
				map.put(String.valueOf(temp),list);
			}
			else{
				ArrayList<String> list = new ArrayList<>();
				list.add(arr[i]);
				map.put(String.valueOf(temp),list);
			}
			    

			}
		
		
		System.out.println(map.entrySet());
		}
	}

