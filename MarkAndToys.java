package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarkAndToys {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        
        int answer = 0;
        int sum=0;
        // Compute the final answer from n,k,prices 
        Arrays.sort(prices);
        for(int i =0;i<n&&sum<=k;i++){
        	if(sum+prices[i]<=k)
        	{
        		answer++;
        		sum+=prices[i];
        	}
        }
        System.out.println(answer);
    }
}
