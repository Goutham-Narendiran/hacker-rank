package com.interview.array;


class Heap{
	int arr[];
	int size;
	public Heap(int arr[],int size){
		this.arr = arr;
		this.size = size;
	}
}
public class HeapSort {
	public static void main(String[] args) {
       int arr[] = {12, 11, 13, 5, 6, 7};
       heapSort(arr);
       for(int i = 0;i<arr.length;i++)
    	   System.out.println(arr[i]);
       
	}

	private static void heapSort(int[] arr) {
		// TODO Auto-generated method stub
		Heap maxHeap = createAndBuildHeap(arr);
		
		while(maxHeap.size>1){
			swap(maxHeap,0,maxHeap.size-1);
			maxHeap.size--;
			maxHeapify(maxHeap,0);
		}
	}

	
	//Buiding a heap takes O(n) time
	private static Heap createAndBuildHeap(int[] arr) {
		// TODO Auto-generated method stub
		Heap maxHeap = new Heap(arr,arr.length);
		
		for(int i = ((arr.length-2)/2);i>=0;i--)
			maxHeapify(maxHeap,i);
		return maxHeap;
	}

	
	//Takes log(n) time
	private static void maxHeapify(Heap maxHeap, int i) {
		// TODO Auto-generated method stub
		int largestIdx = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<maxHeap.size && maxHeap.arr[left]>maxHeap.arr[largestIdx])
			largestIdx = left;
		if(right<maxHeap.size && maxHeap.arr[right] > maxHeap.arr[largestIdx])
			largestIdx = right;
		
		if(i!=largestIdx)
			{
			    swap(maxHeap,i,largestIdx);
			    maxHeapify(maxHeap,largestIdx);
			}
		
	}

	private static void swap(Heap maxHeap, int i, int idx) {
		// TODO Auto-generated method stub
		int temp = maxHeap.arr[i];
		maxHeap.arr[i] = maxHeap.arr[idx];
		maxHeap.arr[idx] = temp;
	}
}
