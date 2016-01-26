package com.interview.array;

public class Sort012 {
	public static void main(String[] args) {
        int arr[] = {2,2,0,2,1,2,1,2,0,0,0};
        sort(arr);
        for(int i =0;i<arr.length;i++)
        	System.out.println(arr[i]);
	}

	private static void sort(int[] arr) {
		// TODO Auto-generated method stub
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		
		while(mid<=high){
			if(arr[mid]==0){
				if(arr[low]!=0){
					swap(arr,low,mid);	
				}
				low++;
				mid++;
				
			}
			else if(arr[mid] == 1){
				mid++;
			}
			else if(arr[mid] == 2){
				if(arr[high]!=2)
					{
					 swap(arr,mid,high);
					}
				 high--;
			}
		}
			
	}

	private static void swap(int[] arr, int low, int mid) {
		// TODO Auto-generated method stub
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
	}
}
