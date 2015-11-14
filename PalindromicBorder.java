package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicBorder {
	static PNode nodes[] = new PNode[100011];
	static char _s[] = new char[100011];
	static char s[];
	static final long mod = 1000000000+7;

	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = input.length();
		s = input.toCharArray();
		///s[-1] = 8;


		PNode r0 = new PNode(0,new PNode(-1));
		PNode curr = r0;

		int nodec= 0;
		for(int i=0;i<n;i++){
			s[i]= (char) (s[i]-'a');
			do{
				while(s[i-curr.length-1]!=s[i]) 
					curr = curr.suffix;
			}
			while(false);

			if(curr.nexts[s[i]]==null){
				PNode suffix;
				if(~curr.length!=0){
					suffix = curr.suffix;
					do{
						while(s[i-suffix.length-1]!=s[i]) 
							suffix = suffix.suffix;
					}
					while(false);

					suffix = suffix.nexts[s[i]];	
				}
				else{
					suffix = r0;
				}
				nodes[nodec++] = curr.nexts[s[i]] = new PNode(curr.length + 2, suffix);	
			}
			curr = curr.nexts[s[i]];
			curr.count++;
		}
		long t =0;
		while(nodec-->0){
			PNode node = nodes[nodec];
			node.suffix.count+= node.count;
			t+= node.count * (node.count-1);
			t%= mod;
		}
		t = t*(mod+1 >> 1)%mod;
		System.out.println(t);
	}
}

class PNode{
	PNode nexts[] = new PNode[8];
	PNode suffix;
	long count;
	int length;
	PNode(int length, PNode suffix){
		this.length = length;
		this.suffix = suffix!=null ?  suffix : this;
		for(int i=0;i<8;i++)
			nexts[i] = null;
		count = 0;
	}

	PNode(int length){
		this.length = length;
		this.suffix = this;
		for(int i=0;i<8;i++)
			nexts[i] = null;
		count = 0;
	}
}