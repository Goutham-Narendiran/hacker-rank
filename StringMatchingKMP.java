package com.interview.array;

public class StringMatchingKMP {
public static void main(String...args){
	String text = "abxabcabcaby";
	String pat = "abcaby";
	KMPSearch(pat,text);
}

private static void KMPSearch(String pat, String text) {
	// TODO Auto-generated method stub
	int M = pat.length();
	int N = text.length();
	int []lps = new int[M];
	computeLPSArray(pat,M,lps);
	
	int i =0;//index of text
	int j=0;//index of pat
	while(i<N){
		if(pat.charAt(j)==text.charAt(i)){
			i++;j++;
		}
		if(j==M){
			System.out.println(i-j);
			j = lps[j-1];//next point of comparison
		}
		else if(i<N && pat.charAt(j)!=text.charAt(i)){
			if(j!=0)
				j = lps[j-1];//next point of comparison
			else
				i++;
		}
	}
}

private static void computeLPSArray(String pat, int M, int[] lps) {
	// TODO Auto-generated method stub
	int len =0;
	int i;
	lps[0] = 0;
	i=1;
	
	while(i<M){
		if(pat.charAt(i)==pat.charAt(len)){
			len++;
			lps[i] = len;
			i++;
		}
		else{
			if(len!=0){
				len = lps[len-1];
			}
			else{
				lps[i]=0;
				i++;
			}
		}
	}
}
}
