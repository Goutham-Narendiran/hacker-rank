package com.interview.array;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.PriorityQueue;

class Coordinate{
	double x;
	double y;
	double distance;
    
	public Coordinate(double x, double y){
		this.x = x;
		this.y = y;
		distance  =  Math.sqrt(x*x + y*y);
	}
	
	public double distance(){
		return distance;
	}

}
public class KNearestPoints {
	public static void main(String[] args) {
        ArrayList<Coordinate> points = new ArrayList<>();
        Random r;
        double x;
        double y;
        int rand;
        for(int i = 0 ; i< 100;i++){
        	r = new Random();
         	rand = r.nextInt(100);
        	x = Math.random()*rand;
        	rand = r.nextInt(100);
        	y = Math.random()*rand;
        	points.add(new Coordinate(x,y));
        }


        points.forEach(p -> System.out.println("X: "+ new DecimalFormat("#.##").format(p.x) + "    Y: "+ new DecimalFormat("#.##").format(p.y) + "    Distance :" + new DecimalFormat("#.##").format(p.distance) ));
        System.out.println();
        System.out.println();
        solve(points,2);
        
        
	}
	private static void solve(ArrayList<Coordinate> points,int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Coordinate> queue = 
	            new PriorityQueue<Coordinate>(10,new Comparator<Coordinate>(){

					@Override
					public int compare(Coordinate c1, Coordinate c2) {
						// TODO Auto-generated method stub
					    if(c1.distance<c2.distance)
					    	return 1;
					    else if(c1.distance>c2.distance)
					    	return -1;
					    else
					    	return 0;
					}
	            	
	            });
		
		for(int i = 0;i<k;i++){
			queue.add(points.get(i));
		}
		
		for(int i = k;i<100;i++){
			if(points.get(i).distance<queue.peek().distance){
				queue.remove();
				queue.add(points.get(i));
			}
		}
		
		queue.forEach(x -> System.out.println("X: "+ new DecimalFormat("#.##").format(x.x) + "    Y: "+ new DecimalFormat("#.##").format(x.y) + "    Distance :" + new DecimalFormat("#.##").format(x.distance) ));
	}
}
