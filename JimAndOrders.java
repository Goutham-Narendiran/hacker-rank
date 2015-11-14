package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Order{
	int c;
	int t;
	int d;
	int order_ready;
	public Order(int c,int t,int d){
		this.c = c;
		this.t=t;
		this.d=d;
		order_ready = t+d;
	}
}

class OrderSort implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		// TODO Auto-generated method stub
		return o1.order_ready-o2.order_ready;
	}
	
}
public class JimAndOrders {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	ArrayList<Order> order = new ArrayList<>();
	String temp[];
	for(int i =0;i<n;i++){
		temp = br.readLine().split(" ");
		order.add(new Order(i+1,Integer.parseInt(temp[0]),Integer.parseInt(temp[1]))) ;
	}
	
	Collections.sort(order,new OrderSort());
	
	for(Order o : order)
		System.out.print(o.c+" ");
	
	
	
}
}
