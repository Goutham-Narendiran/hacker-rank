package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndArray {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	int n;
	String arr[];
	int array [];
	int sum [];
	while(T-->0){
		n = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		array = new int[n];
		int i =0;
		for(String x : arr)
			array[i++] = Integer.parseInt(x);
		sum = new int [n];
		sum[n-1] = array[n-1];
		for(int k = n-2;k>=0;k--){
			sum[k] = sum[k+1] + array[k];
		}
		
		
		int l;
		for(l =0;l<n;l++){
			if(sumFind(l,sum)==true)
				{
				   System.out.println("YES");
				   break;
				}
		}
		
		if(l==n)
			System.out.println("NO");
		
		
		
	}
}

private static boolean sumFind(int l, int[] sum) {
	// TODO Auto-generated method stub
	int left = l-1;
	int right = l+1;
	int leftSum,rightSum;
	if(left<0)
		leftSum = 0;
	else
		leftSum = sum[0]-sum[left+1];
	if(right>=sum.length)
		rightSum = 0;
	else
		rightSum = sum[right];
	
	return leftSum==rightSum;
}
}
