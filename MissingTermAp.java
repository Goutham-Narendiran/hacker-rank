package com.interview.array;

public class MissingTermAp {

	public static void main(String[] args) {
		int arr[] = {1,3,7};
		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {
		if(arr.length<3)
			return -1;

		int diff = (arr[1]-arr[0])<(arr[2]-arr[1]) ? arr[1] -arr[0] : arr[2] - arr[1];

		return solveutil(arr,0,arr.length-1,diff);
	}

	private static int solveutil(int[] arr, int l, int h, int diff) {
		
		if(h<=l)
			return -1;
		int mid = l + (h-l)/2;

		if (mid+1<arr.length && (arr[mid+1]-arr[mid])!=diff){
			return arr[mid]+diff;
		}

		if( mid - 1 >=0 && (arr[mid] - arr[mid-1])!=diff){
			return arr[mid-1] + diff;
		}
		
		if(arr[0] + mid*diff == arr[mid]){
			return solveutil(arr,mid+1,h,diff);
		}
		
		return solveutil(arr,0,mid-1,diff);
		
		
	}
}
