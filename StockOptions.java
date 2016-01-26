package com.interview.array;

public class StockOptions {
	public static void main(String[] args) {
		int price[] = {2, 30, 15, 10, 8, 25, 80};
		System.out.println(solve(price));
	}

	private static int solve(int[] price) {
		// TODO Auto-generated method stub
		int n  = price.length;
		int profit[] = new int[n];
		int maxPrice = price[n-1];
		
		for(int i = n-2;i>=0;i--){
			
			if(price[i]>maxPrice)
				maxPrice = price[i];
			profit[i]=Math.max(profit[i+1], maxPrice - price[i]);
		}
		
		int minPrice = price[0];
		
		for(int i =1;i<n;i++){
			profit[i] = Math.max(profit[i]+price[i]-minPrice,profit[i-1]);
		}
		
		return profit[n-1];
	}
}
