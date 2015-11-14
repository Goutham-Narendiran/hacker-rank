package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CounterGame {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	BigInteger n;
	while(T-->0){
		n = new BigInteger(br.readLine());
		if((setBits((n.subtract(new BigInteger("1"))))&1)>0)
				{
			          System.out.println("Louise");
				}
		else
			System.out.println("Richard");
	}
}

private static int setBits(BigInteger bigInteger) {
	// TODO Auto-generated method stub
	int count=0;
	while(bigInteger.compareTo(BigInteger.ZERO)==1){
		bigInteger = bigInteger.and(bigInteger.subtract(new BigInteger("1")));
		count++;
	}
	
	return count;
}
}
