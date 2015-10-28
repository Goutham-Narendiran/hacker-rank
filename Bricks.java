package com.interview.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bricks {
public static void main(String...args) throws NumberFormatException, IOException{
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	FileReader f = new FileReader(args[0]);
	BufferedReader br = new BufferedReader(f);
	int T = Integer.parseInt(br.readLine());
	long n,arr[],brr[][],x1,y1,z1,A,B,C,x2,y2,z2,x3,y3,z3;
	while(T-->0){
		int i =0;
		n = Integer.parseInt(br.readLine());
		String temp [] = br.readLine().split(" ");
		arr = new long[temp.length];
		for(String s : temp)
			arr[i++] = Integer.parseInt(s);
		brr = new long[temp.length][temp.length];
		for(int gap = 0;gap<=2;gap++){
			for(int k =0,j =gap;k<n-gap;k++,j++){
				if(gap ==0)
					brr[k][j] = arr[k];
				else if(gap == 1)
					brr[k][j] = arr[k]+arr[j];
				else if(gap ==2)
					brr[k][j] = brr[k][j-1] + arr[j];
			}
		}
			for(int gap1 = 3;gap1<n;gap1++){
				for(int l=0,m=gap1;l<n-gap1;l++,m++){
					x1 = (l+2<=m) ? brr[l+2][m] : 0;
					y1= (l+3<=m) ? brr[l+3][m] : 0;
					z1 = (l+4<=m) ? brr[l+4][m] : 0;
					x2 = (l+3<=m) ? brr[l+3][m] : 0;
					y2 = (l+4<=m) ? brr[l+4][m] : 0;
					z2 = (l+5<=m) ? brr[l+5][m] : 0;
					x3 = (l+4<=m) ? brr[l+4][m] : 0;
					y3 = (l+5<=m) ? brr[l+5][m] : 0;
					z3 = (l+6<=m) ? brr[l+6][m] : 0;
					A = arr[l] + Math.min(z1,(Math.min(x1, y1)));
				    B = arr[l]+arr[l+1] + Math.min(z2,(Math.min(x2, y2)));
					C = arr[l]+arr[l+1]+arr[l+2] + Math.min(z3,(Math.min(x3, y3)));
					brr[l][m] = Math.max(C,(Math.max(A, B)));
				}
			}
			System.out.println(brr[0][(int) (n-1)]);
			
		}
	}
}

