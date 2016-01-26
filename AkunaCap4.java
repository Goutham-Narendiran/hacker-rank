package com.interview.array;

public class AkunaCap4 {
	public static int countSetBits(long number){
		int count = 0; while(number>0)
		{ ++count; number &= number-1; } 
		return count; 
		}

	
	public static void main(String args[]){
		long num = 9832498;
		System.out.println(countSetBits(num));
	}
}
