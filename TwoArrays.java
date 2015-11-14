package com.interview.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TwoArrays {
	public static void main(String...args) throws NumberFormatException, IOException{
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		int n,k;
		ArrayList<Long> A;
		ArrayList<Long> B;
		while(T-->0){
			n = kb.nextInt();
			k = kb.nextInt();
			A = new ArrayList<>();
			B = new ArrayList<>();
			for(int i =0;i<n;i++)
				A.add(kb.nextLong());
			for(int i =0;i<n;i++)
				B.add(kb.nextLong());
			Collections.sort(A);
			Collections.sort(B,Collections.reverseOrder());
			
			int i;
			for(i=0;i<n;i++){
				if(A.get(i)+B.get(i)<k)
				{
					System.out.println("NO");
					break;
				}
			}
			if(i==n)
				System.out.println("YES");
		}
		kb.close();
	}
}
