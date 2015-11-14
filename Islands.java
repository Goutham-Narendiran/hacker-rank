package com.interview.array;

public class Islands {
public static void main(String...args){
	int M[][]= {  {1, 1, 0, 0, 0},
	              {0, 1, 0, 0, 1},
	              {1, 0, 0, 1, 1},
	              {0, 0, 0, 0, 0},
	              {1, 0, 1, 0, 1}
	    };
	
	
	System.out.println("No of islands "+countIslands(M,5,5));
}

private static int countIslands(int [][]M,int row,int col) {
	// TODO Auto-generated method stub
    boolean visited[][] = new boolean[row][col];
    int count = 0;
    for(int i=0;i<row;i++){
    	for(int j=0;j<col;j++){
    		if(M[i][j]==1&!visited[i][j])
    			{
    			    Recur(M,i,j,row,col,visited);
    			    count++;
    			}
    		   
    	}
    }
    
    return count;
}

private static void Recur(int[][] m, int i, int j, int row, int col, boolean[][] visited) {
	
	visited[i][j] = true;
	if(i+1<row&&!visited[i+1][j]&&m[i+1][j]==1)
		Recur(m,i+1,j,row,col,visited);
	if(i-1>=0&&!visited[i-1][j]&&m[i-1][j]==1)
		Recur(m,i-1,j,row,col,visited);
	if(j+1<col&&!visited[i][j+1]&&m[i][j+1]==1)
		Recur(m,i,j+1,row,col,visited);
	if(j-1>=0&&!visited[i][j-1]&&m[i][j-1]==1)
		Recur(m,i,j-1,row,col,visited);
	if(i+1<row&&j+1<col&&!visited[i+1][j+1]&&m[i+1][j+1]==1)
		Recur(m,i+1,j+1,row,col,visited);
	if(i-1>=0&&j+1<col&&!visited[i-1][j+1]&&m[i-1][j+1]==1)
		Recur(m,i-1,j+1,row,col,visited);
	if(i+1<row&&j-1>=0&&!visited[i+1][j-1]&&m[i+1][j-1]==1)
		Recur(m,i+1,j-1,row,col,visited);
	if(i-1>=0&&j-1>=0&&!visited[i-1][j-1]&&m[i-1][j-1]==1)
		Recur(m,i-1,j-1,row,col,visited);
	
	
}
}
