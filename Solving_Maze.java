package com.interview.array;

public class Solving_Maze {
	static int shortestDistance;
	public static void main(String...args){
		char arr[][] = {{'X','1','1','1'},
			         	{'X','S','X','1'},
			         	{'1','1','X','1'},
			         	{'1','1','E','1'}};
		shortestDistance = Integer.MAX_VALUE;
		findDistance(arr,1,1,0);
		System.out.println(shortestDistance);
	}
	private static void findDistance(char[][] arr, int i, int j, int distance) {
		// TODO Auto-generated method stub
		if(arr[i][j]=='X'||arr[i][j]=='V')
			return;
		if(arr[i][j]=='E'){
			if(distance<shortestDistance)
				shortestDistance = distance;
			return;
		}
		
		char old = arr[i][j];
		arr[i][j] = 'V';
		
		if(i-1>=0&&(arr[i-1][j]=='1'||arr[i-1][j]=='E')){//up
              findDistance(arr,i-1,j,distance+1);
		}
		if(j+1<4&&(arr[i][j+1]=='1'||arr[i][j+1]=='E')){//right
			findDistance(arr,i,j+1,distance+1);
		}
		if(i+1<4&&(arr[i+1][j]=='1'||arr[i+1][j]=='E')){//down
			findDistance(arr,i+1,j,distance+1);
		}
		if(j-1>=0&&(arr[i][j-1]=='1'||arr[i][j-1]=='E')){//left
			findDistance(arr,i,j-1,distance+1);
		}
		
		arr[i][j] = old;

	}

}
