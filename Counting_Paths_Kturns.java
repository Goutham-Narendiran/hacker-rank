package com.interview.array;

public class Counting_Paths_Kturns {
	int dp[][][][];
	public static void main(String[] args) {
		int m =3, n=3,k =2;
		System.out.println(new Counting_Paths_Kturns().countPaths(m-1, n-1, k));
	}

	private int countPaths(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i==0&&j==0)
			return 1;
		dp = new int[i+1][j+1][k+1][2];
		for(int a =0;a<i+1;a++){
			for(int b =0;b<j+1;b++){
				for(int c=0;c<k+1;c++){
					for(int d=0;d<2;d++)
						dp[a][b][c][d] = -1;
				}

			}
		}
	return countPathUtil(i,j-1,k,0)//moving along the row
			+countPathUtil(i-1,j,k,1);//moving along the column
	}

	private int countPathUtil(int i, int j, int k, int d) {
		// TODO Auto-generated method stub
		if(i<0||j<0)
			return 0;
		if(i==0&&j==0)
			return 1;
		if(k==0)//no turns left
		{
			if(d==0 && i==0)
				return 1;
			if(d==1 && j==0)
				return 1;
			return 0;
		}
		 // If this subproblem is already evaluated
	    if (dp[i][j][k][d] != -1)
	        return dp[i][j][k][d];
	    
		if(d==0)
			return dp[i][j][k][d] = countPathUtil(i, j-1, k, 0) + countPathUtil(i-1, j, k-1, 1);
		return dp[i][j][k][d] = countPathUtil(i-1, j, k, 1) + countPathUtil(i, j-1, k-1, 0);
	}
}
