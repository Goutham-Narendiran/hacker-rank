package com.interview.array;


//O((n+b) * logb(k))
//where n =  number of elements
//b = base
//k = largest possible number

public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {170, 45343, 73435, 34390, 33802, 24, 2, 66,44,3245,2234};
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}

	private static void print(int[] arr, int n) {
		// TODO Auto-generated method stub
           for(int i =0;i<n;i++)
        	   System.out.println(arr[i]);
	}

	private static void radixsort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int m = getMax(arr);
		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m/exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	private static void countSort(int[] arr, int n, int exp) {
		// TODO Auto-generated method stub
		int output[] = new int[n];
		int i;
		int count [] = new int[10];

		// Store count of occurrences in count[]
		for(i = 0 ;i<n ;i++){
			count[(arr[i]/exp)%10]++;
		}

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		
		//Output Array
		for(i = n-1;i>=0;i--){
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		for (i = 0; i < n; i++)
            arr[i] = output[i];
		
	}

	private static int getMax(int[] arr) {
		// TODO Auto-generated method stub
		int max = arr[0];
		for(int i =0;i<arr.length;i++)
			if(arr[i]>=max)
				max = arr[i];
		return max;
	}
}
