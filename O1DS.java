package com.interview.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class O1DS {
	private static HashMap<Integer,Integer> map;
	private static ArrayList<Integer> list;
public static void  main(String...args){
	map = new HashMap<>();
	list = new ArrayList<>();
    insert(1);
    print();
    insert(0);
    print();
    insert(8);
    print();
    insert(0);
    print();
    insert(6);
    print();
    insert(12);
    print();
    delete(8);
    print();
    delete(6);
    print();
    search(8);
    print();
    search(12);
    print();
    getRandom();
   
}
private static void print() {
	// TODO Auto-generated method stub
	 System.out.println(map.entrySet());
	    for(int x : list)
	    	System.out.print(x+" ");
	    System.out.println();
	
}
private static void getRandom() {
	// TODO Auto-generated method stub
	Random rand = new Random();
	int k = rand.nextInt(list.size());
	System.out.println(list.get(k));
}
private static void search(int i) {
	// TODO Auto-generated method stub
	if(map.containsKey(i))
		System.out.println("Found at index"+map.get(i));
	else
		System.out.println("Element not found");
}
private static void delete(int i) {
	// TODO Auto-generated method stub
	if(map.containsKey(i)){
	    list.set(map.get(i),list.get(list.size()-1));
	    map.put(list.get(list.size()-1),map.get(i));
	    map.remove(i);
	    list.remove(list.size()-1);		
	}
	
	else{
		System.out.println("Element not found");
	}
	
}
private static void insert(int i) {
	// TODO Auto-generated method stub
	if(!map.containsKey(i))
	{
		list.add(i);
		map.put(i,list.size()-1);
	}
	
}
}
