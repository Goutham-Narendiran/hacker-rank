package com.interview.array;

public class CountingDearrangment2 {
	public static void main(String...args){
	      int n = 4;
	      int arr[] = new int [n+1];
	      arr[0]=1;
	      arr[1]=0;
	      arr[2]=1;
	      
	      for(int i=3;i<=n;i++)
	    	  arr[i] = (i-1)*(arr[n-1]+arr[n-2]);
	      
	      System.out.println(arr[n]);
	}     
}
