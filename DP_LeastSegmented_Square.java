package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Point{
	public double x;
	public double y;
	Point(double i, double j){
		x = i;
		y = j;
	}
}

public class DP_LeastSegmented_Square {
	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(0,0));
		list.add(new Point(0,2));
		list.add(new Point(1,2.3));
		list.add(new Point(2,2.6));
		list.add(new Point(3,2.9));
		list.add(new Point(4,3.2));
		list.add(new Point(5,22));
		list.add(new Point(6,26));
		list.add(new Point(7,30));
		list.add(new Point(8,34));
		list.add(new Point(9,38));

		new Solve(10,list).findSegments(1);
	}
}

class Solve{
	ArrayList<Point> list;
	long cum_x[];
	long cum_y[];
	long cum_xy[];
	long cum_xSqr[];
	double opt[];
	int opt_seg[];
	int n;
	double slope[][];
	double intercept[][];
	double E[][];

	public Solve(int n,ArrayList<Point> list){
		this.list = list;
		this.n = n;
		Collections.sort(list, new Comparator<Point>(){
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return (int) (o1.x-o2.x);
			}
		});
		cum_x = new long[n+1];
		cum_y= new long[n+1];
		cum_xy= new long[n+1];
		cum_xSqr= new long[n+1];
		opt = new double[n+1];
		opt_seg = new int[n+1];
		slope = new double[n+1][n+1];
		intercept = new double[n+1][n+1];
		E = new double[n+1][n+1];
	}

	public void findSegments(int C) {
		// TODO Auto-generated method stub
		int i,j,k,interval;
		long x_sum, y_sum, xy_sum, xSqr_sum, num, denom;
		double tmp, mn;

		cum_x[0] = cum_xSqr[0] = cum_y[0] = cum_xSqr[0] = 0;

		for(j=1;j<=n;j++){
			cum_x[j] = (long) (cum_x[j-1] + list.get(j).x);
			cum_y[j] = (long) (cum_y[j-1] + list.get(j).y);
			cum_xy[j] = (long) (cum_xy[j-1] + list.get(j).x*list.get(j).y);
			cum_xSqr[j] = (long) (cum_xSqr[j-1] + list.get(j).x*list.get(j).x);

			for(i=1;i<=j;i++){
				interval = j-i+1;
				x_sum = cum_x[j] - cum_x[i-1];
				y_sum = cum_y[j] - cum_y[i-1];
				xy_sum = cum_xy[j] - cum_xy[i-1];
				xSqr_sum = cum_xSqr[j] - cum_xSqr[i-1];

				num = interval * xy_sum - x_sum * y_sum;

				if(num==0)
					slope[i][j] = 0.0;
				else{
					denom = interval * xSqr_sum - x_sum * x_sum;
					slope[i][j] = (denom == 0.0) ? Double.POSITIVE_INFINITY : ((double)num/(double)denom);
				}
				intercept[i][j] = (y_sum - slope[i][j] * x_sum) / (double)interval;

				for (k = i, E[i][j] = 0.0; k <= j; k++)	{
					tmp = list.get(k).y - slope[i][j] * list.get(k).x - intercept[i][j];
					E[i][j] += tmp * tmp;
				}
			}
		}

		//
		opt[0] = opt_seg[0] = 0;

		for(j =1;j<=n;j++){
			for(i =1,mn = Double.POSITIVE_INFINITY, k =0;i<=j;i++){
				tmp = E[i][j] + opt[i-1];
				if(tmp < mn){
					mn = tmp;
					k = i;
				}
			}
			opt[j] = mn + C;
			opt_seg[j] = k;
		}

		System.out.println("Optimal Sol " + opt[n]);
		Stack<Integer> s = new Stack<>();
		for (i = n, j = opt_seg[n]; i > 0; i = j-1, j = opt_seg[i])	{
			s.push(i);
			s.push(j);
		}

		System.out.println("Optimal Segments are:");

		while(!s.isEmpty()){
			i = s.pop();
			j = s.pop();
			System.out.println("Segment (y ="+slope[i][j]+"x "+" + "+intercept[i][j]+") from points "+i+" to "+j
					+" with squared error of "+ E[i][j]);
		}


	}



}
