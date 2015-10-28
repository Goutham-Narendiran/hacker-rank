package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	while(T-->0){
		String str = br.readLine();
		if(str.length()%2!=0)
		{
			System.out.println(-1);
			continue;
		}
		String s1 = str.substring(0,str.length()/2);
		String s2 = str.substring(str.length()/2);
		int arr1[] = new int[26];
		int arr2[] = new int[26];
		int count = 0;
		for(int i=0;i<s1.length();i++){
			arr1[s1.charAt(i)-'a']++;
			arr2[s2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++){
			if(arr1[i]>arr2[i])
				count+=arr1[i]-arr2[i]; 
		}
		System.out.println(count);
	}
}
}
