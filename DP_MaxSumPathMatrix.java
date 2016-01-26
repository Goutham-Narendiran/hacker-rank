package com.interview.array;

public class DP_MaxSumPathMatrix {
	public static void main(String[] args) {
       int arr[][] = {{1,2,3,4,5,6},
    		          {4,8,2,0,8,6},
    		          {1,5,3,3,9,1}};
       
       System.out.println(solve(arr,3,6));
	}

	private static int solve(int[][] arr, int m, int n) {
		// TODO Auto-generated method stub
		int cost[][] = new int[m][n];
		cost[0][0] = arr[0][0];//base case
		
		for(int i=1;i<n;i++)
			cost[0][i] = arr[0][i];
		
		for(int i =1;i<m;i++)
			for(int j = 0;j<n;j++){
				if(j-1>=0 && j+1<n)
					cost[i][j] = Math.max(cost[i-1][j], Math.max(cost[i-1][j-1], cost[i-1][j+1])) + arr[i][j];
				else if(j-1>=0)
					cost[i][j] = Math.max(cost[i-1][j],cost[i-1][j-1] ) + arr[i][j];
				else
					cost[i][j] = Math.max(cost[i-1][j],cost[i-1][j+1] ) + arr[i][j];
			}
		
		int max = -1;
		for(int i=0;i<n;i++)
			max = Math.max(max,cost[m-1][i]);
		return max;
				
	}
}