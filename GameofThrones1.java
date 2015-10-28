package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameofThrones1 {
	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		if(len == 1)
			System.out.println("YES");
		else if(len == 2){
			if(str.charAt(0)==str.charAt(1))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}

		else{
			boolean isPan = true;
			char count[] = new char[26];
			for(int i=0;i<len;i++){
				count[str.charAt(i)-'a']++;
			}
			if(len%2==0){
				for(int i = 0;i<26;i++){
					if(count[i]%2!=0)
					{
						isPan = false;
						break;
					}
				}
			}
			else{
				int oddCount = 0;
				//int evenCount =0;
				for(int i = 0;i<26;i++){
					if(count[i]>0){
						if(count[i]%2!=0)
							oddCount++;		 
					}
					if(oddCount>1)
						isPan= false;
				}
			}
			
			if(isPan)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
