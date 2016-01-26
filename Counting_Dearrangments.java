package com.interview.array;

public class Counting_Dearrangments {
	public static void main(String...args){
      int n = 4;
      int arr[] = new int[n+1];
      arr[0]=1;
      int ans = 0;
      for(int i =1;i<n+1;i++)
    	  arr[i] = i*arr[i-1];
      for(int i=2;i<n+1;i++){
    	  if(i%2==0)
    		  ans +=arr[n]/arr[i];
    	  else
    		  ans -=arr[n]/arr[i];
      }
      System.out.println(ans);
	}
}
