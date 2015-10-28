package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RestoreIPAddresses {
	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String digits = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		String oct1 = "";
		String oct2 = "";
		String oct3 = "";
		//  String oct4 = "";
		if(digits.length()>12||digits.length()<4)
			return;
		if(digits.length()==4){
			list.add(digits.substring(0,1)+"."+digits.substring(1,2)+"."+digits.substring(2,3)+"."+digits.substring(3,4));
			for(String x : list)
				System.out.println(x);
			return;
		}
		for(int i =1;i<=3;i++){
			oct1 = digits.substring(0,i);
			boolean leadingZero1 = false;
			if(oct1.length()>1&&oct1.charAt(0)=='0')
				leadingZero1 =true;
			if(Integer.parseInt(oct1)>255||digits.length()-oct1.length()>9||digits.length()-oct1.length()<3||leadingZero1)
				continue;
			for(int j =i+1;j<=i+3;j++){
				boolean leadingZero2 = false;
				oct2 = digits.substring(i,j);
				if(oct2.length()>1&&oct2.charAt(0)=='0')
					leadingZero2 =true;
				if(Integer.parseInt(oct2)>255||digits.length()-oct1.length()-oct2.length()>6||digits.length()-oct1.length()-oct2.length()<2||leadingZero2)
					continue;  
				for(int k=j+1;k<=j+3&&k<=digits.length();k++){
					boolean leadingZero3 = false;
					boolean leadingZero4 = false;
					oct3 = digits.substring(j,k);
					if(oct3.length()>1&&oct3.charAt(0)=='0')
						leadingZero3 =true;
					if(Integer.parseInt(oct3)>255||(digits.length()-oct1.length()-oct2.length()-oct3.length()>3||digits.length()-oct1.length()-oct2.length()-oct3.length()<1)||k>digits.length()||leadingZero3)
						continue; 
					if(digits.substring(k).length()>1&&digits.substring(k).charAt(0)=='0')
						leadingZero4 = true;
					if(!digits.substring(k).isEmpty()&&leadingZero4==false&&Integer.parseInt(digits.substring(k))<=255)
						list.add(oct1+"."+oct2+"."+oct3+"."+digits.substring(k));
				}

			}
		}
		for(String x : list)
			System.out.println(x);
	}
}
