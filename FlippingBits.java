package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlippingBits {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
        long num,maxInt = (long) (Math.pow(2,32)-1);
        
	while(T-->0){
		num = Long.parseLong(br.readLine());
		num = (long) (maxInt-num);
	    System.out.println(num);
	}
}
}
