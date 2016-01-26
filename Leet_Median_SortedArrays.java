package com.interview.array;

import java.util.Arrays;

public class Leet_Median_SortedArrays {
	public static void main(String[] args) {
		int arr[] = {100,101,102};
		int brr[] = {1,2,3,4,5,6};
		System.out.println(solve(arr,arr.length,brr,brr.length));
	}

	private static double solve(int[] arr,int n, int[] brr,int m) {
		// TODO Auto-generated method stub
		if(arr==null || brr == null)
			return -1;
		if(arr.length==0){
			if(brr.length%2==0)
				return (brr[m/2]+brr[m/2-1])/2.0;
			return brr[m/2];
		}
		if(brr.length==0){
			if(arr.length%2==0)
				return (arr[n/2]+arr[n/2-1])/2.0;
			return arr[n/2];
		}
			
		if ( n > m )
			return solveUtil( brr, m, arr, n );

		return solveUtil( arr, n, brr, m );
	}

	private static double solveUtil(int[] arr,int n, int[] brr,int m) {
		// TODO Auto-generated method stub
		if(n==1){
			if(m==1)
				return median(arr[0],brr[0]);
			if((m&1)==1){
				return median(brr[m/2],median(arr[0],brr[m/2-1],brr[m/2+1]));
			}

			return median(arr[0],brr[m/2],brr[m/2-1]);
		}

		else if(n==2){
			if(m==2)
				return  median(arr[0],arr[1],brr[0],brr[1]);
			if((m&1)==1)
				return median(brr[m/2],Math.max(arr[0],brr[m/2-1]),Math.min(arr[1],brr[m/2+1]));
			return
					median(brr[m/2],brr[m/2-1],Math.max(brr[m/2-2], arr[0]),Math.min(brr[m/2+1], arr[1]));
		}

		int idx1 = (n-1)/2;
		int idx2 = (m-1)/2;

		if(arr[idx1]<=brr[idx2]){
			return solveUtil(Arrays.copyOfRange(arr,idx1,arr.length),n/2+1,brr,m-idx1);
			}
		return solveUtil( arr, n / 2 + 1, Arrays.copyOfRange(brr,idx1,brr.length), m - idx1 );


	}


	private static double median(int a, int b, int c, int d) {
		// TODO Auto-generated method stub
		int max = Math.max(a, Math.max(b,Math.max(c, d)));
		int min = Math.min(a, Math.min(b, Math.min(c, d)));
		return (a+b+c+d - max-min)/2.0;
	}

	private static int median(int a, int b, int c) {
		// TODO Auto-generated method stub
		return a+b+c - Math.max(a,Math.max(b,c))- Math.min(a,Math.min(b, c));
	}

	private static double median(int a, int b) {
		// TODO Auto-generated method stub
		return (a+b)/2.0;
	}
}
