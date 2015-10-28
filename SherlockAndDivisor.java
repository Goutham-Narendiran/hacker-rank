package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndDivisor {
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int n = Integer.parseInt(br.readLine());
			int ans=0,temp;
			if(n%2!=0)
			{
				System.out.println(0);
				continue;
			}
			ans =1;
			for(int k = 2;k<=Math.sqrt(n);k++){
				if(n%k==0){
					if(k%2==0&&n/k==k)
						ans = ans+1;
				     else if(k%2==0&&(n/k)%2==0)
						ans = ans+2;
					else if(k%2==0||(n/k)%2==0)
						ans = ans+1;
				}
			}

			System.out.println(ans);
		}
	}
}
