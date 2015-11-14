package com.interview.array;

import java.util.Scanner;

public class ChiefHopper {
public static void main(String...args){
	Scanner kb = new Scanner(System.in);
	int N = kb.nextInt();
	double B=0;
	double A;
	int ans = 0;
	for(int i =0;i<N;i++){
		{
			 B=B+Pow(2,N-1-i)*kb.nextInt();
		}
		
	    A = Pow(2,N);
	    ans = (int) Math.ceil(B/A);
	}
	System.out.println(ans);
}

private static int Pow(int n, int exp) {
	// TODO Auto-generated method stub
	if(exp==0)
		return 1;
	if(exp==1)
		return n;
	if(exp==2)
		return n*n;
	if(exp%2==0)
		return(Pow(n*n,exp/2));
	else
		return(n*Pow(n*n,(exp-1)/2));
}
}
