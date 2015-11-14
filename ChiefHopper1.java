package com.interview.array;

import java.util.Scanner;

public class ChiefHopper1 {
public static void main(String...args){
	Scanner kb = new Scanner(System.in);
	int N = kb.nextInt();
	double B;
	double A;
	int arr[]=new int[N];
	double ans = 0;
	for(int i =0;i<N;i++){
		arr[i]= kb.nextInt();
	}
	for(int i=N-1;i>=0;i--){
		ans = Math.ceil((arr[i]+ans)/2);
	}
	System.out.println((int)ans);
}
}

