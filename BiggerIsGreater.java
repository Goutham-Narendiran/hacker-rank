package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggerIsGreater {
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-->0){
			String w = br.readLine();
			String p1="",p2="";
			int i;
            char alpha[] = new char[26];
            for(int j = 0;j<w.length();j++)
    			alpha[w.charAt(j)-'a']++;
            
			for(i = w.length()-2;i>0;i--){
				p1 = w.substring(0,i);
				p2 = w.substring(i);
				p2 = sort(p2);
				if(!w.equals(p1.concat(p2)))
					break;
			}

			if(i>0)
				System.out.println(p1.concat(p2));
			else if (i==0){
			   	char str [] = new char[w.length()];
			   	int nextIndex = nextChar(w,alpha);
			   	if(nextIndex==-1)
			   		System.out.println("no answer");
			   	else{
			   		char ans[] = new char[w.length()];
			   		int j=0;
			   		ans[j++]=(char) ((char)nextIndex + 'a');
			   		for(int k = 0;k<26;k++){
			   			if(alpha[k]>0)
			   				ans[j++] = (char) (k+'a');
			   		}
			   		
			   		System.out.println(String.valueOf(ans));
			   	}
			}
		}
	}

	private static int nextChar(String w,char []alpha) {
		// TODO Auto-generated method stub
		for(int i = w.charAt(0)-'a'+1;i<26;i++){
			if(alpha[i]>0){
				alpha[i]--;
				return i;
			}
		}
		return -1;
	}

	private static String sort(String s) {
		// TODO Auto-generated method stub
		int arr[] = new int[26];
		for(int j = 0;j<s.length();j++)
			arr[s.charAt(j)-'a']++;

		char brr[] = new char[s.length()];
		int i =0;
		for(int j =25;j>=0;j--){
			if(arr[j]>0){
				while(arr[j]-->0)
					brr[i++] = (char) ('a'+j);
			}
		}

		return String.valueOf(brr);
	}
}
