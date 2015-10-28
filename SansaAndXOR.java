package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SansaAndXOR {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	
	while(T-->0){
		int n = Integer.parseInt(br.readLine());
		String temp [] = br.readLine().split(" ");
		int arr[] = new int [n];
		//int xor[] = new int [n+1];
		int i =0;
		for(String x : temp){
			arr[i++] = Integer.parseInt(x);
		}
	
		int result=0;
		if(arr.length%2!=0){
			for(i=0;i<n;i=i+2)
				result^=arr[i];
		}
		
		
		
		System.out.println(result);
	}
}

}
