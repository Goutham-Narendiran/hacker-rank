package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingTriangles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[] = new int[N];
        long acute=0,right=0,obtuse=0;
        for(int i=0; i < N; i++){
            A[i] = in.nextInt();
        }
        Arrays.sort(A);
        
       for(int i =0;i<N-2;i++){
    	   int k = i+2;
    	   for(int j =i+1;j<N-1;j++){
    		   while(k<N&&A[i]+A[j]>A[k]){
    			  long a = A[i]*A[i];
    			  long b = A[j]*A[j];
    			  long c = A[k]*A[k];
    			  if(a+b==c)
    				  right++;
    			  else if(a+b<c)
    				  obtuse++;
    			  else 
    				  acute++;
    			  
    			  k++;
    		   }
    		   k = j+2;
    	   }
       }
        System.out.println(acute+" "+right+" "+obtuse);
       
    }
}
