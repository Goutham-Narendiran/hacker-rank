package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggerisGreater1 {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
    
	while(T-->0){
		String w = br.readLine();
		String p1="",p2="";
		int i;
		
		for(i = w.length()-2;i>=0;i--){
			p1 = w.substring(0,i);
			p2 = w.substring(i);
			p2 = sortUtil(p2);
			if(p2==null)
				continue;
			else{
				System.out.println(p1.concat(p2));
				break;
			}
		}
		
		if(i<0)
			System.out.println("no answer");

	}
}

private static String sortUtil(String p2) {
	// TODO Auto-generated method stub
	int alpha[] = new int[26];
	char str[] = new char[p2.length()];
    for(int j = 0;j<p2.length();j++)
		alpha[p2.charAt(j)-'a']++;
    
    int i;
    for(i = p2.charAt(0)-'a'+1;i<26;i++){
		if(alpha[i]>0){
			{
				alpha[i]--;
				break;
			}
		}
	}
    if(i<26){
    	int j =0;
    	str[j++] = (char) ((char)i + 'a');
    	for(int k = 0;k<26;k++){
   			while(alpha[k]-->0)
   				str[j++] = (char) (k+'a');
   		}
    	
    	return String.valueOf(str);
    }
  	return null;
    
}
}
