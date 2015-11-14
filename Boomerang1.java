package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Boomerang1 {

	private static long temp;
	public static void main(String[] args) {
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));		
		try
		{   
			int T= Integer.parseInt(inp.readLine());

			for(int i=0;i<T;i++)
			{
				long n= Integer.parseInt(inp.readLine());
				System.out.println(findUtil(n));	
			}
		}
		catch(Exception e){
		}
	}

	private static long findUtil(long n) {
	   long result =0;
	   long k;
	   for(int i =2;i<=n;i++){
		   if(i%2==0){
			   k = i/2+1;
		   }
		   else
		       k=1;
		   result = (result+k)%i;
	   }
	   return result+1;
	}
}
