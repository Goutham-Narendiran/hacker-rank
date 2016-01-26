package com.interview.array;

import java.util.Arrays;
import java.util.Comparator;

public class Largestnumber {
public static void main(String[] args) {
	int arr[] = {0,0};
	System.out.println(solve(arr));
}

private static String solve(int[] arr) {
	// TODO Auto-generated method stub
	String[] brr = new String[arr.length];
	
	
	for(int i =0;i<arr.length;i++){
		brr[i] = String.valueOf(arr[i]);
	}
	Arrays.sort(brr,new Comparator<String>(){

		@Override
		public int compare(String i, String j) {
			// TODO Auto-generated method stub
			String a = i+j;
			String b = j+i;
			return b.compareTo(a);
		}	
	});
	
   
   String result = "";
	for(String x : brr){
		result = result.concat(x);
	}
	
	if(result.matches("(0+)"))
		return "0";
	return result;
}
}
