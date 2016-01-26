package com.interview.array;

public class MaximumSumNoAdjacent {
	public static void main(String[] args) {
       int arr[] = {5, 5, 10, 100, 10, 5};
       System.out.println(solve(arr));
	}

	
	//greedy approach
	private static int solve(int[] arr) {
		// TODO Auto-generated method stub
		int inc = arr[0];
		int exc = 0;
		int exe_new;
		
		for(int  i =1;i<arr.length;i++){
			
			exe_new = Math.max(inc,exc);
			inc  = exc + arr[i];
			exc = exe_new;
		}
		
		return Math.max(inc,exc);
	}
}
