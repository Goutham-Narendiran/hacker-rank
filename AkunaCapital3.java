package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;

public class AkunaCapital3 {
	public static void main(String args[]){
		int arr[] = {1,2,2,4,7,8,5,4,3,4,6};
		ArrayList<Integer> result = new ArrayList<>();
		boolean input[] = new boolean[99999999];
		for(int i=0;i<arr.length;i++){
			if(input[arr[i]] == false)
			{
				result.add(arr[i]);
				input[arr[i]] = true;
			}
		}
	
		Collections.sort(result);
		Collections.reverse(result);
		for(int j =0;j<result.size();j++)
			System.out.println(result.get(j));
		
		int final_list[] = new int[result.size()];
	        for(int j =0;j<result.size();j++)
	            final_list[j] = result.get(j);
			
		
	}
	
}
