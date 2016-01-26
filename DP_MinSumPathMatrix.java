package com.interview.array;

public class DP_MinSumPathMatrix {
	public static void main(String[] args) {
       int arr[][] = {{1,2,3},
    		          {4,8,2},
    		          {1,5,3}};
       
       System.out.println(solve(arr,3,3));
	}

	private static int solve(int[][] arr, int m, int n) {
		  // TODO Auto-generated method stub
		  int cost[][] = new int[m][n];
		  cost[0][0] = arr[0][0];
		  
		  for(int k =1;k<n;k++)
			  cost[k][0] = cost[k-1][0] + arr[k][0];
		  for(int k = 1;k<m;k++)
			  cost[0][k] = cost[0][k-1] + arr[0][k];
		  
		  for(int i =1;i<m;i++)
			  for(int j =1;j<n;j++)
				  cost[i][j] = Math.min(cost[i-1][j],Math.min(cost[i-1][j-1],cost[i][j-1])) + arr[i][j];
		  return cost[m-1][n-1];
	}
}
