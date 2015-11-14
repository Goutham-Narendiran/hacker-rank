package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Boomerang {

	private static long temp;
	public static void main(String[] args) {


		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		
		try
		{   
			int T= Integer.parseInt(inp.readLine());

			for(int i=0;i<T;i++)
			{
				
				long n= Integer.parseInt(inp.readLine());
				if(n%2==0)
					System.out.println((findUtil(n,(n/2)+1)));	
				else
					System.out.println(findUtil(n,1));
			}
		}
		catch(Exception e){

		}


	}

	private static long findUtil(long n, long k) {
		// TODO Auto-generated method stub
		if(n==1)
			return 1;
		else if((n-1)%2!=0)
			return temp=((findUtil(n-1,1)+k-1)%n+1);	
		else
			return temp = ((findUtil(n-1,((n-1)/2)+1)+k-1)%n+1);
	}
}
