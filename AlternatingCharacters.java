package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {
public static void main(String...args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	while(T-->0){
	String str = br.readLine();
	char prev = str.charAt(0);
	int count = 0;
	for(int i=1;i<str.length();i++){
		if(str.charAt(i)==prev)
			count++;
		else
			prev = str.charAt(i);
	}
	
	System.out.println(count);
	}
}
}
