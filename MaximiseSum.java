package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximiseSum {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());

	long arr[];
	long sum[];
	long M;
	int N;
	while(T-->0){
		String temp[] = br.readLine().split(" ");
		N = Integer.valueOf(temp[0]);
		M = Integer.valueOf(temp[1]);
		temp = br.readLine().split(" ");
		int i =0;
		arr = new long[N];
		sum = new long[N];
		for(String s : temp)
			arr[i++] = Long.parseLong(s);
		
		sum[N-1] = arr[N-1];
		for(i = (N-2);i>=0;i--){
			sum[i] = sum[i+1]+arr[i];
		}
		
		long ans = Long.MIN_VALUE,curr;
		for(int j =0;j<N;j++){
			for(int k = j;k<N;k++){
			   curr = rangeSum(j,k,sum,M);
			   if(curr>ans)
				   ans = curr;
			}
		}
		
		System.out.println(ans);
	}
}

private static long rangeSum(int j, int k, long[] sum,long M) {
	// TODO Auto-generated method stub
	if(j==k||k+1==sum.length)
		return sum[j]%M;
	else
		return (sum[j] - sum[k+1])%M;
}
}
