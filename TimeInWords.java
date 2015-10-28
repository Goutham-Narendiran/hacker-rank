package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TimeInWords {
public static void main(String...args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String H = br.readLine(); //1-11
	String M = br.readLine(); //0-59
	
	HashMap<Integer,String> hourmap = new HashMap<Integer,String>();
	hourmap.put(1,"one");
	hourmap.put(2,"two");
	hourmap.put(3,"three");
	hourmap.put(4,"four");
	hourmap.put(5,"five");
	hourmap.put(6,"six");
	hourmap.put(7,"seven");
	hourmap.put(8,"eight");	
	hourmap.put(9,"nine");
	hourmap.put(10,"ten");
	hourmap.put(11,"eleven");
	hourmap.put(12,"twelve");
	
	HashMap<Integer,String> minutemap = new HashMap<Integer,String>();
	minutemap.put(0,"NULL");
	minutemap.put(1,"one");
	minutemap.put(2,"two");
	minutemap.put(3,"three");
	minutemap.put(4,"four");
	minutemap.put(5,"five");
	minutemap.put(6,"six");
	minutemap.put(7,"seven");
	minutemap.put(8,"eight");	
	minutemap.put(9,"nine");
	minutemap.put(10,"ten");
	minutemap.put(11,"eleven");
	minutemap.put(12,"twelve");
	minutemap.put(13,"thirteen");
	minutemap.put(14,"fourteen");
	minutemap.put(15,"fifteen");
	minutemap.put(16,"sixteen");
	minutemap.put(17,"seventeen");
	minutemap.put(18,"eighteen");
	minutemap.put(19,"nineteen");
	minutemap.put(20,"twenty");
	minutemap.put(15,"quarter");
	
	
	String hour = hourmap.get(Integer.parseInt(H));
	String display = "";
	
	if(M.charAt(0)=='3' && M.charAt(1)=='0')
		display = "half past "+hour;
	else if(M.charAt(0)=='0'&&M.charAt(1)=='0') //case 1 : O' clock
	{
	   display = hour+" "+"o' clock";
//	   System.out.println("display");
	}
	
	else if((M.charAt(0)=='0')||(M.charAt(0)=='1')||(M.charAt(0)=='2')){
		if(M.charAt(0)=='1'&&M.charAt(1)=='5')
			display = "quarter past "+hour;
		else{
			if(M.charAt(0)=='0'){
				if(M.charAt(1)=='1')
					display = minutemap.get(1)+" "+"minute past "+hour;
				else
					display = minutemap.get(Integer.parseInt(M.substring(1)))+" "+"minutes past "+hour;
			}
			else if(M.charAt(0)=='1'){
				 display = minutemap.get(Integer.parseInt(M))+" minutes past "+hour;
			}
			else{
				if(M.charAt(1)=='0')
					display = minutemap.get(Integer.parseInt(M))+" minutes past "+hour;
				else
					display = minutemap.get(20)+" "+minutemap.get(Integer.parseInt(M.substring(1)))+" minutes past "+hour;
			}
		}
	}
	
	else{
		int diff = 60 - Integer.parseInt(M);
		hour = hourmap.get(Integer.parseInt(H)+1);
		if(diff==1)
			display = minutemap.get(diff)+" "+"minute to "+ hour;
		else if(diff == 15)
			display = minutemap.get(diff)+" "+"to "+hour;
		else if(diff>=2&&diff<=20){
			display = minutemap.get(diff)+" "+"minutes to "+hour;
		}
		else{
				display = minutemap.get(20)+" "+minutemap.get(diff%10)+" minutes to "+hour;
		}
	}
	
	System.out.println(display);
	
}
}
