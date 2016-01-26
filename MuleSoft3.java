package com.interview.array;

public class MuleSoft3 {
public static void main(String[] args) {
	int arr[] = {2,2,3,4,3,3,2,2,1,1,3,5};
	System.out.println(solve(arr,arr.length));
}

private static int solve(int[] arr, int length) {
	// TODO Auto-generated method stub
	int i =0,j;
	int extremum = 0;
	
	for(j=i;j<length;){
		if(arr[i]==arr[j]){
			if((j==length-1) && ((arr[j]>arr[i-1])||(arr[j]<arr[i-1])))
				extremum++;
			j++;
			continue;
		}
			
		else if((i==0 && ((arr[j]>arr[i])||(arr[j]<arr[i])))){
			extremum ++;
		}
			
		else if((arr[i-1]>arr[i])&&(arr[j]>arr[j-1])){
			extremum++;
		}
			
		else if((arr[i-1]<arr[i])&&(arr[j]<arr[j-1])){
           extremum++;
		}
		
	    i = j;
			
	}
	
	return extremum;
}
}
