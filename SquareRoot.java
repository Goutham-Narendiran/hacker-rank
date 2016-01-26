package com.interview.array;

public class SquareRoot {
	public static void main(String[] args) {
		double n = 1000000000;
		System.out.println(sqrt(n));
	}

	private static String sqrt(double d) {
		// TODO Auto-generated method stub
		double mid;
		int count=0;
		double s = 0,e = d;
		while(true){
			count++;
			mid = (s + e)/2;
			if(mid*mid<d)
				s = mid;
			else if(mid*mid>d)
				e = mid;
			if(Math.abs(mid*mid - d)<0.0000001)
				{
				System.out.println(count);
				return String.format("%.3f", mid);
				}
			
		}
	}
}
