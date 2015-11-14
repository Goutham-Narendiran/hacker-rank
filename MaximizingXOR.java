package com.interview.array;

import java.util.Scanner;

public class MaximizingXOR {
public static void main(String...args){
	Scanner kb = new Scanner(System.in);
	int L = kb.nextInt();
	int R = kb.nextInt();
	int ans = 0,b1,b2;
	for(int i=0;i<10;i++){
		b1 = (L & 1<<i)>>i;
		b2 = (R & 1<<i)>>i;
		if((b1==1&&b2==1)||(b1==0&&b2==0)){
			int t1 = L^1<<i;
			int t2= R^1<<i;
			if((t1>=L&&t1<=R)||(t2>=L&&t2<=R)){
				//ans+= Math.pow(2,i)*1;
			
				    ans+=Math.pow(2,i)*1;
			}
		}
		
		else{
			
			    ans+=Math.pow(2,i)*1;
		}
	}
	System.out.println(ans);
}
}
