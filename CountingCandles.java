package com.interview.array;

import java.util.Scanner;

public class CountingCandles {
	static final int mod = 1000000000+7;
	@SuppressWarnings("resource")
	public static void main(String...args){
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int K = kb.nextInt();
		int H;
		int C;
		int maxH = 50002;
		int maxC = 1 << K;
		int[][] bit = new int[maxC][];
		for (int i = 0; i < maxC; i++) {
			bit[i] = new int[maxH];
		}
		updateBinaryIndexedTree(bit[0],1,0);
		for(int i=0;i<N;i++){
			H= kb.nextInt();
			C= kb.nextInt()-1;
			
			 for (int j = 0; j < maxC; j++) {
	                int add = getSum(bit[j], H-1);
	                //updateBinaryIndexedTree(bit[0], add, H);
	                updateBinaryIndexedTree(bit[j|1<<C], add, H);
	            }
		}
		
		  int ans = getSum(bit[(1<<K)-1], maxH-2);
		//int ans = getSum(bit[0], maxH-2);
	        System.out.println(ans);

	}

	public static void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index){
		       index = index+1;
		while(index < binaryIndexedTree.length){
			binaryIndexedTree[index] += val;
			binaryIndexedTree[index] %=mod;
			index = getNext(index);
			//System.out.println("S");
		}
	}

	public static int getSum(int binaryIndexedTree[], int index){
		index = index+1;
		int sum = 0;
		while(index > 0){
			sum += binaryIndexedTree[index];
			sum %=mod;
			index = getParent(index);
			//System.out.println("S");
		}
		return sum;
	}

	/**
	 * To get parent
	 * 1) 2's complement to get minus of index
	 * 2) AND this with index
	 * 3) Subtract that from index
	 */
	private static int getParent(int index){
		return index - (index & -index);
	}

	/**
	 * To get next
	 * 1) 2's complement of get minus of index
	 * 2) AND this with index
	 * 3) Add it to index
	 */
	private static int getNext(int index){
		return index + (index & -index);
	}
}


