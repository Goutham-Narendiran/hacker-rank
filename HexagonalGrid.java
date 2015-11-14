package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HexagonalGrid {
	private static boolean canfit;
	private static int grid[][];
	private static int N;
	private static int dx[] = {0, 1, 1};
	private static int dy[] = {1, 0, -1};
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		String temp;
		while(T-->0){
			N = kb.nextInt();
			grid = new int[2][N];
			temp = kb.next();
			for(int i=0;i<N;i++)
				grid[0][i] = Integer.parseInt(String.valueOf(temp.charAt(i)));

			temp = kb.next();
			for(int i=0;i<N;i++)
				grid[1][i] = Integer.parseInt(String.valueOf(temp.charAt(i)));

			canfit = false;
			rec();
            if(canfit)
            	System.out.println("YES");
            else
            	System.out.println("NO");

		}



	}
	private static void rec() {
		// TODO Auto-generated method stub
		if(canfit) return;
		boolean change =false;
		for (int i = 0; i < 2 && !change && !canfit; ++i) {
			for (int j = 0; j < N && !change && !canfit; ++j) {
				if (grid[i][j] == 0) {
					change = true;
					for (int k = 0; k < 3 && !canfit; ++k) {
						if (is_in(i + dx[k], j + dy[k]) && grid[i + dx[k]][j + dy[k]] == 0) {
							grid[i][j] = 1;
							grid[i + dx[k]][j + dy[k]] = 1;
							rec();
							grid[i][j] = 0;
							grid[i + dx[k]][j + dy[k]] = 0;
						}
					}
				}
			}
		}
		
		if (!change) {
		    canfit = true;
		  }
	}
	private static boolean is_in(int i, int j) {
		// TODO Auto-generated method stub
		return (0 <= i && i < 2 && j >= 0 && j < N);
	}
}