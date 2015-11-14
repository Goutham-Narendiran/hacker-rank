package com.interview.array;

import java.util.Arrays;

public class LIS_IN_NLOGN {
public static void main(String...args){
	int A[] = {1,3,2,4};
	int size = A.length;
	System.out.println(LIS(A,size));
}

private static int LIS(int[] A, int size) {
	// TODO Auto-generated method stub
	int T[] = new int[size];
	int R[] = new int[size];//contains the indices of longest increasing subseq
	Arrays.fill(R,-1);
	int len;//always point to empty slot
	T[0]=0;
	len=1;
	
	for(int i=1;i<size;i++){
		if(A[i]<A[T[0]])//new smallest value
			T[0] = i;
		else if(A[i]>A[T[len-1]])//A[i] will extend the largest subseq
			{
			 R[i] = T[len-1];
			   T[len++] = i;
			  
			}
		else{
			/*A[i] wants to current end candidate of an existing subseq 
			 * It will replace the existing ceil value in the tail table
			 * */
			int temp = ceilIndex(A,T,0,len-1,A[i]);
			T[temp] = i;
			R[i] = T[temp-1];
		}
	}
	
	return len;
}

private static int ceilIndex(int[] A, int[] T, int l, int r, int key) {
	// TODO Auto-generated method stub
	int m;
	while(r-l>1){
		m = (r+l)/2;
		if(A[T[m]]>=key)
			r = m;
		else
			l = m;
	}
	
	return r;
}
}
