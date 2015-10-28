package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SquareDigitChain {
	
	private static long sos_digits(int n){
		int s=0;
		while(n>0){
			s = s + (int)Math.pow((n % 10),2)%1000000007;
			n = n / 10;
		}
		return s;
		
	}
	private static boolean unhappy(int n){
		while (n > 1 && n != 89 && n != 4)
	        n = (int) sos_digits(n);
	    return n>1;
	}
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int Lc = (int)Math.pow(9.0, 2.0)*L+1;
		
//		long[]t = new long[(int)Lc];
//		long[]solutions = new long[(int)Lc];
//		Arrays.fill(t, 0);
//		Arrays.fill(solutions, 0);
		
		BigInteger[] t = new BigInteger[Lc];
		BigInteger[] solutions = new BigInteger[Lc];
		
		for(int i=0;i<Lc;i++){
			t[i] = new BigInteger("0");
		    solutions[i] = new BigInteger("0");
		    }
		

		for(int i=0;i<10;i++)
		{
			solutions[i*i] = BigInteger.ONE;
		}
		
		BigInteger temp;
		for(int i=2; i<L+1;i++){
			for(int j=0; j<Lc; j++){
				temp = BigInteger.ZERO;
				for(int k=0; k<10; k++){
					if(k*k<=j)
						temp = temp.add(solutions[j - k*k]).mod(new BigInteger("1000000007"));
						}
				t[j] = temp;
			}
			solutions = t;
		}
		
		BigInteger res = BigInteger.ZERO;
		for(int i = 1;i< Lc;i++)
			if(unhappy(i))
				res = res.add(solutions[i]).mod(new BigInteger("1000000007"));		
		System.out.println(res.mod(new BigInteger("1000000007")));

	}
}


