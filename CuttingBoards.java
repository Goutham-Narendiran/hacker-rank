package com.interview.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CuttingBoards {
	static final long mod = 1000000000+7;
	public static void main(String...args){
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		int M,N;
		int xSeg;
		int ySeg;
		Long x[];
		Long y[];
		while(T-->0){
			M = kb.nextInt();
			N = kb.nextInt();
			y= new Long[M-1];
			x= new Long[N-1];
			for(int i=0;i<M-1;i++)
				y[i] = kb.nextLong();
			for(int i=0;i<N-1;i++)
				x[i] = kb.nextLong();

			Arrays.sort(y,Collections.reverseOrder());
			Arrays.sort(x,Collections.reverseOrder());
			xSeg =1;
			ySeg =1;
			long cost=0;
			int i,j;
			for(i=0,j=0;(i<M-1)&&(j<N-1);){
				if(M>N){
					if(y[i]>=x[j]){
						ySeg++;
						cost=(cost+y[i]*xSeg)%mod;
						i++;
					}
					else {
						xSeg++;
						cost=(cost+x[j]*ySeg)%mod;
						j++;
					}
				}
				else{
					if(x[j]>=y[i]){
						xSeg++;
						cost=(cost+x[j]*ySeg)%mod;
						j++;
					}
					else {
						ySeg++;
						cost=(cost+y[i]*xSeg)%mod;
						i++;
					}
				}
			}

			if(i<M-1){
				for(int k=i;k<M-1;k++){
					cost=(cost+y[k]*xSeg)%mod;
				}
			}
			else if(j<N-1){
				for(int k=j;k<N-1;k++){
					cost=(cost+x[k]*ySeg)%mod;
				}
			}
			System.out.println(cost);

		}
	}
}
