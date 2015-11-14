package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ANDProduct {
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long a,b,ans,c;
		while(T-->0){
			ans =0;
			String temp[] = br.readLine().split(" ");
			a = Long.parseLong(temp[0]);
			b = Long.parseLong(temp[1]);
			for(int i =31;i>=0;i--){
				if(((a&(1<<i))==(b&(1<<i)))){
					ans = (long) (ans +((a&(1<<i))>>i)*Math.pow(2,i));
				}
				else 
					break;

			}

			System.out.println(ans);
		}
	}
}
