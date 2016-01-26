package com.interview.array;

public class AkunaCapital2 {
	public static void main(String args[]){
		int arr[] = {2,8,9,7};
	    int max = -1;
	    int n = arr.length;
	    int largest_no = arr[n-1];
	    for(int i = n-2;i>=0;i--){
	    	if(arr[i]<largest_no){
	    		if(arr[i]*largest_no>max)
	    			max = arr[i]*largest_no;
	    	}
	    	else
	    		largest_no = arr[i];
	    }
	    
	    System.out.println(max);
	}
}
