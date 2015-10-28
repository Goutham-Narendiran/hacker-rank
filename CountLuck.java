package com.interview.array;

import java.io.IOException;
import java.util.Scanner;

class Coor{
	int x;
	int y;
	public Coor(int x,int y)
	{
		this.x= x;
		this.y= y;
	}
}
public class CountLuck {
	public static void main(String...args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		int N,M,K,ans;
		char forest[][];
		while(T-->0){
			N = kb.nextInt();
			M = kb.nextInt();
			forest = new char[N][M];

			for(int i =0;i<N;i++)
				forest[i] = kb.next().toCharArray();
			K = kb.nextInt();

			Coor hm = getCoor(forest,N,M);
			ans = getK(forest,N,M,0,hm.x,hm.y);
			if(ans==K)
				System.out.println("Impressed");
			else
				System.out.println("Oops!");
		}
	}

	private static int getK(char[][] forest, int n, int m, int k, int x, int y) {
		// TODO Auto-generated method stub		
		int path =0,A,B,C,D;
		if(forest[x][y]=='*')
			return k;
		forest[x][y] = 'V';
		
		path = (x+1<n && (forest[x+1][y]=='.'||forest[x+1][y]=='*')) ? path+1 : path;
		path = (x-1>=0 &&( forest[x-1][y]=='.'||forest[x-1][y]=='*')) ? path+1 : path;
		path = (y+1<m && (forest[x][y+1]=='.'||forest[x][y+1]=='*')) ? path+1 : path;
		path = (y-1>=0 && (forest[x][y-1]=='.'||forest[x][y-1]=='*')) ? path+1 : path;

		if(path>=1){
			if(path>1)
			    k++;
			A = (x+1<n && (forest[x+1][y]=='.'||forest[x+1][y]=='*')) ?  getK(forest,n,m,k,x+1,y) : -1;
			B = (x-1>=0 && (forest[x-1][y]=='.'||forest[x-1][y]=='*')) ? getK(forest,n,m,k,x-1,y) : -1;
			C = (y+1<m && (forest[x][y+1]=='.'||forest[x][y+1]=='*')) ?  getK(forest,n,m,k,x,y+1) : -1;
			D = (y-1>=0 && (forest[x][y-1]=='.'||forest[x][y-1]=='*')) ? getK(forest,n,m,k,x,y-1) : -1;
			
			return Math.max(k, Math.max(A, Math.max(B, Math.max(C, D))));
		}
		
		else
			return -1; 
    	}

	private static Coor getCoor(char[][] forest,int N,int M) {
		// TODO Auto-generated method stub
		for(int i =0;i<N;i++)
			for(int j =0;j<M;j++)
				if(forest[i][j]=='M'){
					Coor hm = new Coor(i,j);
					return hm;
				}

		return null;
	}
}
