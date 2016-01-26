package com.interview.array;

public class AkunaCap5 {
public static void main(String args[]){
	int arr[] = new int[256];
	int brr[] = new int[256];
	String s = "aaaaa";
	String t = "aaa";
	for(int i =0;i<s.length();i++){
		arr[s.charAt(i)]++;
	}
	for(int i =0;i<t.length();i++){
		brr[t.charAt(i)]++;
	}
	
	String f = "";
	for(int i=0;i<arr.length;i++){
		if(arr[i]>0&&brr[i]>0){
			int char_num = 	(arr[i]>brr[i]) ?  brr[i] : arr[i];
			char string [] = new char[char_num];
			for(int k = 0;k<char_num;k++)
				string[k] = (char)i;
			f = f.concat(new String(string));
		}	
	}
	System.out.println(f);
}
}
