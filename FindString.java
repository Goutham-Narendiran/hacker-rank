package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindString {
	static char []input;
	static int max[];
	static int length;
	static int sa[];
	static int lcp[];
	static String s = "";
	static int n;
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());


		String arr[] = new String[n];
		for(int i=0;i<n;i++){
			arr[i]=br.readLine();
			s+=arr[i]+"A";
		}

		input = s.toCharArray();

		max=new int[input.length];
		int som =0;
		for( int i = 0 ; i < n ; i++ ){
			int nu = arr[i].length() ;

			for( int j = som ; j < som + nu ; j++)
				max[j] = som + nu ;

			som += nu ;

		}
		length = input.length;
		sa = suffixArray(input);
		lcp = lcp_kasai(sa,input);
		n = input.length;
		int q = Integer.parseInt(br.readLine());
		for( int i = 0 ; i < q ; i++ )
			losOp(Long.parseLong(br.readLine())) ;


	}
	private static void losOp(long k) {
		// TODO Auto-generated method stub
		int start = 0 ;
		for( int i = 0 ; i < n ; i++ ){			

			int ind = sa[i] ;
			start = lcp[i] ;

			long aantal = Math.max(0,max[ind] - 1 - ind - start) ;
			//System.out.println("Zoek " + s.substring(ind) + " " + ind + " " + aantal + " " + start);
			if( input[ind] != 'A' && aantal >= k ){
				System.out.println(s.substring(ind, (int) (ind+start+k))) ;
				return ;
			}else if( input[ind] != 'A')
				k -= aantal ;
			//System.out.println(k);


		}

		System.out.println("INVALID") ;


	}
	public static int[] suffixArray(char[] input) {
		int n = input.length;
		Integer[] order = new Integer[n];
		for (int i = 0; i < n; i++)
			order[i] = n - 1 - i;

		// stable sort of characters
		Arrays.sort(order, (a, b) -> Character.compare(input[a], input[b]));

		int[] sa = new int[n];
		int[] classes = new int[n];
		for (int i = 0; i < n; i++) {
			sa[i] = order[i];
			classes[i] = input[i];
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
	public static int[] lcp_kasai(int []sa,char[] s){
		int n = sa.length;
		int rank[] = new int[sa.length];
		int lcp[] = new int[sa.length];
		Arrays.fill(rank, 0);
		Arrays.fill(lcp, 0);
		for(int i=0;i<n;i++) rank[sa[i]]=i;
		int k=0;
		for(int i=0; i<n; i++)
		{
			if(rank[i]==n-1) {k=0; continue;}
			int j=sa[rank[i]+1];
			while(i+k<n && j+k<n && s[i+k]==s[j+k]) k++;
			lcp[rank[i]]=k;
			if(k>0)
				k--;
			else
				k=0;
		}
		return lcp;

	}
}
