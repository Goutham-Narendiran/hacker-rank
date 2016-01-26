package com.interview.array;

public class StockOptionsKtimes {
public static void main(String[] args) {
	int prices[] = {2, 30, 15, 10, 8, 25, 80};
    int x = solve(prices,2);
    System.out.println(x);
}

private static int solve(int[] prices,int K) {
	// TODO Auto-generated method stub
	if(K==0||prices.length==0){
		return 0;
	}
	
	int T[][] = new int[K+1][prices.length];
	for(int i =1;i<K+1;i++){
		int maxDiff = -prices[0];
		for(int j =1;j<prices.length;j++){
			T[i][j] = Math.max(T[i][j-1], prices[j]+maxDiff);
			maxDiff = Math.max(maxDiff, T[i-1][j]-prices[j]);
		}
		
	}
	
	return T[K][prices.length-1];
	
    }
}
