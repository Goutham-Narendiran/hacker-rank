package com.interview.array;

import java.util.Scanner;

public class EmmasNotebook {
public static void main(String...args){
	Scanner kb = new Scanner(System.in);
	int t = kb.nextInt();
	long num,ans;
	if(t==1)
		ans =1;
	else if(t%2==0){
	   num = t/2+1;	
	   ans = ((num-1)*(num))-1+num;
	   
	}
	else{
		num = t/2+1;
		ans = num*(num+1)-1;
	}
	
	System.out.println(ans);
}
}
