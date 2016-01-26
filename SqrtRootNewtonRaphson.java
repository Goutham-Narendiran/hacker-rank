package com.interview.array;

public class SqrtRootNewtonRaphson {
	public static void main(String[] args) {
       double n =  1000000000;
       System.out.println(sqrt(n));
	}

	private static String sqrt(double n) {
		// TODO Auto-generated method stub
		double xo;
		double xn;
		int i;
		for(i =0;Math.pow(2,i)<n;i++);
		xo = i;
		int count = 0;
		while(true){
			count++;
			xn = xo -  (xo*xo - n)/(2*xo);
			if(Math.abs(xn*xn - n)<0.0001){
				System.out.println(count);
				return String.format("%.3f",xn);
				
			}
				
			xo = xn;	
			
		}
	}
}
