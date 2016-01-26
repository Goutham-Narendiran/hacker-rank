package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSimilarity {
	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		while(T-->0){
			str = br.readLine();
			System.out.println(stringSimilarity(str.toCharArray(),str.toCharArray()));
		}

	}

	private static long stringSimilarity(char[] text, char[] pattern) {
		// TODO Auto-generated method stub
		char newString[] = new char[text.length+pattern.length+1];
		int i =0;
		for(char p : pattern)
			newString[i++] = p;
		newString[i] = '$';
		for(char t : text)
			newString[++i] = t;
 
		long z[] = calculateZ(newString);

		long result = 0;
		for(int k =text.length+1;k<z.length;k++)
		{
			result+=z[k];
		}
		return result;
	}

	private static long[] calculateZ(char[] input) {
		// TODO Auto-generated method stub
		long[] z =new long [input.length];
		int left=0;
		int right=0;
		for(int k=1;k<input.length;k++){
			if(k>right){
				left = right = k;
				while(right<input.length&&input[right] == input[right-left])
					right++;
				z[k]=right-left;
				right--;
			}
			else{
				//we are operating inside box
				int k1= k-left;
				//if the value doesnot stretch till the right bound, just copy it
				if(z[k1]+k<right+1)
					z[k]= z[k1];
				else{
					//comparisons
					left = k;
					while(right<input.length&&input[right]==input[right-left])
						right++;
					z[k] = right-left;
					right--;
				}
			}
		}
		return z;
	}
}
