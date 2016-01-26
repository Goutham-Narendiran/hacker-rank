package com.interview.array;

public class StringAndSubString {
	public static void main(String[] args) {
         System.out.println(solve("aaaaaa"));
	}

	private static boolean solve(String string) {
		// TODO Auto-generated method stub
		int lps [] = computeLPS(string);
		int len = lps[lps.length-1];
		int n = string.length();
		
		return n%(n-len)==0?true:false;
	}
	
	private static int [] computeLPS(String str){
		int n = str.length(); 
		int lps[] = new int[n];
		lps[0] = 0;
		int i = 1;
		int len = 0;
		
		while(i<n){
			if(str.charAt(i) == str.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}
			
			else{
				if(len!=0){
					len = lps[len-1];
				}
				else{
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}
}
