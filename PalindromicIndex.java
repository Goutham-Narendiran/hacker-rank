package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicIndex {
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-->0){
			String str = br.readLine();
			if(isPalindrome(str))
			{
				System.out.println(-1);
				continue;
			}
			
			for(int i =0;i<str.length();i++){
				if(isPalindrome(str.substring(0,i)+str.substring(i+1)))
					{
					   System.out.println(i);
					   break;
					}
			}
			
			
		}
	}

	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = str.length()-1;
		while(i<=j){
			if(str.charAt(i)==str.charAt(j))
			{
				i++;
				j--;
			}
			
			else
				break;
		}
		if(i>j)
			return true;
		return false;
	}
}
