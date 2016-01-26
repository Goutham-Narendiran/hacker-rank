package com.interview.array;

public class MergeSort {
	public static void main(String[] args) {
       int arr[] = {2,5,4,3,5,6,7,5,4,3,2,1,2,3,4,5,6,7,8,9,0,8,7,5,4,3,2,6,8,12,5,0,8};
       int n = arr.length;
       mergeSort(arr,0,n-1);
       
       for(int i = 0;i<n;i++)
    	   System.out.println(arr[i]);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r){
			int m = l + (r-l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1 = m - l +1;
		int n2 = r - m;
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		for(int i = 0;i<n1;i++){
			L[i] = arr[l+i];
		}
		
		for(int i =0; i<n2;i++){
			R[i] = arr[m+1+i];
		}
		
        int i =0;
        int j =0;
        int k = l;
        
        while(i<n1 && j < n2){
        	if(L[i]<=R[j]){
        		arr[k] = L[i];
        		i++;
        	}
        	else if(L[i]>R[j]){
        		arr[k] = R[j];
        		j++;
        	}
        	
        	k++;
        }
        
        while(i<n1){
        	arr[k++] = L[i++];
        }
        
        while(j<n2){
        	arr[k++] = R[j++];
        }
	}
}
