package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class MaxMin {
    
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      int K = Integer.parseInt(in.readLine());
      int[] list = new int[N];

      for(int i = 0; i < N; i ++)
         list[i] = Integer.parseInt(in.readLine());
      
      Arrays.sort(list);
      int unfairness = Integer.MAX_VALUE;
      
      int i,j;
      for(i=0,j=K-1;i<j&&j<N&&i<N;i++,j++){
    	  unfairness = Math.min(unfairness,list[j]-list[i]);
      }
      System.out.println(unfairness);
   }
}
