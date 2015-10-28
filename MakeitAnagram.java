package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeitAnagram {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int arr1[] = new int[26];
		int arr2[] = new int[26];
		int count = 0;
		for(int i=0;i<s1.length();i++)
			arr1[s1.charAt(i)-'a']++;
		for(int i=0;i<s2.length();i++)
			arr2[s2.charAt(i)-'a']++;
		
		for(int i=0;i<26;i++){
				count+=Math.abs(arr1[i]-arr2[i]); 
		}
		System.out.println(count);
	}
}

