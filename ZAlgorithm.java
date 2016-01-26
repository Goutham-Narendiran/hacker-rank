package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
	public static void main(String...args){
		String text = "";
		String pattern = "aabxaabxcaabxaabxay";
		List<Integer> list = matchPattern(text.toCharArray(),pattern.toCharArray());
		for(int i : list)
			System.out.println(i);


	}

	private static List<Integer> matchPattern(char[] text, char[] pattern) {
		// TODO Auto-generated method stub
		char newString[] = new char[text.length+pattern.length+1];
		int i =0;
		for(char p : pattern)
			newString[i++] = p;
		newString[i] = '$';
		for(char t : text)
			newString[++i] = t;

		List<Integer> result = new ArrayList<>();
		int z[] = calculateZ(newString);

		for(int k =0;k<z.length;k++)
		{
			if(pattern.length==z[k])
				result.add(k-pattern.length-1);
		}
		return result;
	}

	private static int[] calculateZ(char[] input) {
		// TODO Auto-generated method stub
		int z [] =new int [input.length];
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
