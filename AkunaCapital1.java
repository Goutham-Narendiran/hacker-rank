package com.interview.array;

import java.util.Arrays;

public class AkunaCapital1 {
	public static void main(String args[]){
		int arr[] = {2,3,8,1,6};
		int target = 100;
		Arrays.sort(arr);
		int i =0,j = arr.length-1;
		while(i<=j){
			if(arr[i]*100+arr[j]*100==target)
				{
				   System.out.println("true");
				   break;
				}
			else if(arr[i]*100+arr[j]*100<target)
				i++;
			else
				j--;
		}
		
	}
}
