package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class knapsack {
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n,k,i;
		int v[],w[];
		String temp1[];
		String temp2[];
		int a;
		
		while(T-->0){
			temp1 = br.readLine().split(" ");
			n = Integer.parseInt(temp1[0]);
			k = Integer.parseInt(temp1[1]);
			temp2 = br.readLine().split(" ");
			v = new int[temp2.length];
			i =0;
			for(String x:temp2)
				v[i++] = Integer.parseInt(x);
            w = new int[k+1];
            Arrays.fill(w, 0);
            for(int p = 0;p<v.length;p++)
            	for(int q = 0;q<=k;q++){
                    if(v[p]<=q)
                    	w[q] = Math.max(w[q],w[q-v[p]]+v[p]);
            	}
            
            System.out.println(w[k]);
			
		}
	}
}
