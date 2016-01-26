package com.interview.array;

public class MuleSoft2 {
	public static void main(String[] args) {
		int A[] = {};
		System.out.println(solve(A));
	}

	private static int solve(int A[]) {
		// TODO Auto-generated method stub
		if(A == null||A.length==0)
			return -1;
		
		int idx=0,i,j=0;
		int prevLen = 1;
		int len[] = new int[A.length];
		len[0]=1;
		for(i = 1;i < A.length;i++){

			if(A[i]>A[i-1]){
				len[i] = Math.max(len[i-1], i-j+1);
			}

			else{
				len[i] = len[i-1];
				j = i;
			}

			if(len[i]>prevLen){
				prevLen = len[i];
				idx = j;
			}

		}
		System.out.println("Length = "+len[A.length-1]);
		return idx;
	}
}
