package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {
	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = 2*str.length()-1;
		String max = "";
		for(int i = 0 ;i<n;i++){
			if(i%2==0){
				String temp = longPalindrome(str,i>>1);
				max = temp!=null&&temp.length()>max.length() ? temp : max;
			}
			else{
				String temp = longPalindrome(str,i>>1,(i>>1)+1);
				max = temp!=null && temp.length()>max.length() ? temp : max;
			}
		}
		System.out.println(max);
	}

	private static String longPalindrome(String str, int i, int j) {
		// TODO Auto-generated method stub
		int p,q;
		for(p =i,q=j; p>=0 && q<str.length();p--,q++){
			if(!(str.charAt(p)==str.charAt(q)))
				break;
		}
		return str.substring(p+1,q);	
	}
	private static String longPalindrome(String str, int i) {
		// TODO Auto-generated method stub
		int p,q;
		for(p =i,q=i; p>=0 && q<str.length();p--,q++){
			if(!(str.charAt(p)==str.charAt(q)))
				break;
		}
		return str.substring(p+1,q);
	}
}
