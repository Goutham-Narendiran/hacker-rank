package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MorganAndString {
public static void main(String...args) throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	String A,B;
	int lenA,lenB;
	StringBuilder out;
	while(T-->0){
		out = new StringBuilder();
		A = br.readLine()+'a';
		lenA = A.length();
		B = br.readLine()+'z';
		lenB = B.length();
		int [] suffixArray = suffixArray(A+B);
	    int pos1=0,pos2=0;
	    while(true){
	    	if(pos1>=lenA-1&&pos2>=lenB-1)
	    		break;
	    	if(pos1>=lenA-1)
	    		{
	    		 out.append(B.charAt(pos2++));
	    		 continue;
	    		}
	    	if(pos2>=lenB-1){
	    		out.append(A.charAt(pos1++));
	    		 continue;
	    	}
	    	if(suffixArray[pos1]<suffixArray[lenA+pos2])
	    		out.append(A.charAt(pos1++));
	    	else
	    		out.append(B.charAt(pos2++));	
	    }
		
	    System.out.println(out.toString());
	}
}

public static int[] suffixArray(CharSequence S) {
	
	 class CharComp implements Comparator<Integer>{


	    	@Override
	    	public int compare(Integer o1, Integer o2) {
	    		// TODO Auto-generated method stub
	    		return S.charAt(o1)-S.charAt(o2);
	    	}
	    	
	    }
    int n = S.length();
    Integer[] order = new Integer[n];
    for (int i = 0; i < n; i++)
      order[i] = n - 1 - i;

    // stable sort of characters
    //Arrays.sort(order,(a, b)->Character.compare(S.charAt(a), S.charAt(b)));
     Arrays.sort(order,new CharComp());

    int[] sa = new int[n];
    int[] classes = new int[n];
    for (int i = 0; i < n; i++) {
      sa[i] = order[i];
      classes[i] = S.charAt(i);
    }
    // sa[i] - suffix on i'th position after sorting by first len characters
    // classes[i] - equivalence class of the i'th suffix after sorting by first len characters

    for (int len = 1; len < n; len *= 2) {
      int[] c = classes.clone();
      for (int i = 0; i < n; i++) {
        // condition sa[i - 1] + len < n simulates 0-symbol at the end of the string
        // a separate class is created for each suffix followed by simulated 0-symbol
        classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
      }
      // Suffixes are already sorted by first len characters
      // Now sort suffixes by first len * 2 characters
      int[] cnt = new int[n];
      for (int i = 0; i < n; i++)
        cnt[i] = i;
      int[] s = sa.clone();
      for (int i = 0; i < n; i++) {
        // s[i] - order of suffixes sorted by first len characters
        // (s[i] - len) - order of suffixes sorted only by second len characters
        int s1 = s[i] - len;
        // sort only suffixes of length > len, others are already sorted
        if (s1 >= 0)
          sa[cnt[classes[s1]]++] = s1;
      }
    }
    return sa;
    
  }



}






