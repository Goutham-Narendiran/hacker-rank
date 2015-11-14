package com.interview.array;

public class PartitionProblem {
	public static void main(String...args){
		int arr []={1,11,5,5};
		System.out.println(findPartition(arr,arr.length));
	}

	private static boolean findPartition(int[] arr, int length) {
		// TODO Auto-generated method stub
		int sum =0;
		int i,j;
		for(i =0;i<length;i++)
			sum+= arr[i];
		if(sum%2!=0)
			return false;

		boolean partition[][] = new boolean[sum/2+1][length+1];

		for(i=0;i<=length;i++)
			partition[0][i] = true;
		for(i=1;i<=sum/2;i++)
			partition[i][0] = false;

		for(i =1;i<=sum/2;i++){
			for(j=1;j<=length;j++){
				partition[i][j] = partition[i][j-1];
				if(i>=arr[j-1]){
					partition[i][j] = partition[i][j]||
							partition[i-arr[j-1]][j-1];
				}
			}
		}

		for(i =0;i<=sum/2;i++){
			for(j=0;j<=length;j++)
				{System.out.print(partition[i][j]+" ");}
		System.out.println();}

		return partition[sum/2][length];
	}
}
