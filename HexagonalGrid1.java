package com.interview.array;

import java.util.*;

public class HexagonalGrid1 {
	private static boolean ans;
	private static int grid[][];
	private static int N;
	private static int x[] = {0, 1, 1};
	private static int y[] = {1, 0, -1};
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		String temp;
		while(T-->0){
			ans = false;
			N = kb.nextInt();
			grid = new int[2][N];
			temp = kb.next();
			for(int i=0;i<N;i++)
				grid[0][i] = Integer.parseInt(String.valueOf(temp.charAt(i)));

			temp = kb.next();
			for(int i=0;i<N;i++)
				grid[1][i] = Integer.parseInt(String.valueOf(temp.charAt(i)));

			eval();
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}



	}
	private static void eval() {
		// TODO Auto-generated method stub
		if(ans) return;
		boolean change = false;
		for(int i=0;i<2;i++){
			for(int j=0;j<N;j++){
				if(grid[i][j]==0){
					change = true;
					for(int k=0;k<3;k++){
						if(isvalid(i+x[k],j+y[k])&&grid[i+x[k]][j+y[k]]==0){
							grid[i][j]=1;
							grid[i+x[k]][j+y[k]]=1;
							eval();
							grid[i][j]=0;
							grid[i+x[k]][j+y[k]]=0;
						}
					}
				}
			}
		}
		if(!change)
			ans= true;

	}
	private static boolean isvalid(int i, int j) {
		// TODO Auto-generated method stub
		if(i<2&&i>=0&&j<N&&j>=0)
			return true;
		return false;
	}

}