package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cipher {
public static void main(String...args) throws NumberFormatException, IOException{
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	@SuppressWarnings("resource")
	Scanner kb = new Scanner(System.in);
	int N = kb.nextInt();
	int K = kb.nextInt();
	String code = kb.next();
	short d[] = new short[N+K-1];
	short a[] = new short[N];
		
	d[0] = Short.parseShort(String.valueOf(code.charAt(0)));
	a[0] = d[0];
	System.out.print(a[0]);
	int i;
	for(i=1;i<K&&i<N;i++)
		{  
		   d[i] = Short.parseShort(String.valueOf(code.charAt(i)));
		   a[i]=(short) (d[i]^d[i-1]);
		   System.out.print(a[i]);
		}
	int x=0;
	for(int j = i;j<N;j++){
		d[j] = Short.parseShort(String.valueOf(code.charAt(j)));
		a[j] = (short) (d[j]^d[j-1]^a[x++]);
		System.out.print(a[j]);
	}
	
}
}
