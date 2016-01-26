package com.interview.array;

import java.util.Random;

public class RandQuickSort {
	public static void main(String[] args) {
		int arr[] = {2,3,4,3,3,2,3,4,5,4,3,4,5,6,7,8};
		int n = arr.length;
		quickSort(arr,0,n-1);
		for(int i =0 ;i<n;i++)
			System.out.println(arr[i]);
	}

	private static void quickSort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub

		if(l<r)
		{
			int p = rand_partition(arr,l,r);

			quickSort(arr,l,p-1);

			quickSort(arr,p+1,r);
		}

	}

	private static int rand_partition(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int i = rand.nextInt(r-l) + l;
		swap(arr,i,r);
		return partition(arr, l, r);
	}

	private static int partition(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		int x = arr[r];
		int i = l;
		int j = r-1;

		while(i<j){
			while(i <=r-1 && arr[i]<=x)
				i++;
			while(j>=l && arr[j]>x)
				j--;
			if(i<j){
				swap(arr,i,j);
				i++;
				j--;
			}
		}

		swap(arr,i,r);
		return i;
	}

	private static void swap(int[] arr, int leftptr, int rightptr) {
		// TODO Auto-generated method stub
		int temp = arr[leftptr];
		arr[leftptr] = arr[rightptr];
		arr[rightptr] = temp;
	}
}
