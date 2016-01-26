package com.interview.array;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Surrounded_Regions {
	public static void main(String[] args) {
		char region [][] = {{'X','X','X','X'},
				            {'X','O','X','X'},
				            {'X','X','O','O'},
				            {'X','O','O','X'}};
		surround(null);
		
	}

	private static void surround(char[][] region) {
		// TODO Auto-generated method stub
		if(region==null)
			return;
		int rows = region.length;
		int cols = region[0].length;
		Queue<Point> que = new LinkedList<>();

		for(int i=0;i<rows;i++){
			if(region[i][0]=='O'){
				region[i][0] = '+';
				que.add(new Point(i,0));
			}
			if(region[i][cols-1]=='O'){
				region[i][cols-1] = '+';
				que.add(new Point(i,cols-1));
			}
		}

		for(int i=1;i<cols-1;i++){
			if(region[0][i]=='O'){
				region[0][i] = '+';
				que.add(new Point(0,i));
			}
			if(region[rows-1][i]=='O'){
				region[rows-1][i] = '+';
				que.add(new Point(rows-1,i));
			}
		}

		while(!que.isEmpty()){
			Point p = que.poll();
			int row = p.x;
			int col = p.y;
			if(row-1>=0&&region[row-1][col]=='O'){
                 region[row-1][col] = '+';
                 que.add(new Point(row-1,col));
			}
			if(row+1<rows&&region[row+1][col]=='O'){
				region[row+1][col] = '+';
                que.add(new Point(row+1,col));
			}
			if(col-1>=0&&region[row][col-1]=='O'){
				region[row][col-1] = '+';
                que.add(new Point(row,col-1));
			}
			if(col+1<cols&&region[row][col+1]=='O'){
				region[row][col+1] = '+';
                que.add(new Point(row,col+1));
			}
		}
		
		for(int i =0;i<rows;i++){
			for(int j = 0; j< cols;j++){
				if(region[i][j] == '+'){
					region[i][j] = 'O';
				}
				else if(region[i][j] == 'O')
					region[i][j] = 'X';
				System.out.print(region[i][j]+" ");
			}
			System.out.println();
		}

	}


}
