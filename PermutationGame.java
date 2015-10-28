package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PermutationGame{
	private static int arr[] = new int[32770];
	public static void main(String...args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;

		while(T-->0){
			n = Integer.parseInt(br.readLine());
			for(int i = 0;i<32768;i++)
				arr[i] = -1;
			int a[] = new int[n];
			String temp[] = br.readLine().split(" ");
			int i=0;
			for(String x : temp)
				a[i++] = Integer.parseInt(x);
			int res=permu(a,n,(1<<n)-1);
			
			if(res==1)
				System.out.println("Alice");
			else
				System.out.println("Bob");
		}
	}

	private static int permu(int[] a, int n, int r) {
		// TODO Auto-generated method stub
		if(arr[r]!=-1)
			return arr[r];
		int last=0,i;
		for(i=0;i<n;i++)
		{
			if(get1(r,i)==1)
			{
				if(a[i]>last)
					last=a[i];
				else 
					break;
			}
		}

		if(i==n) //Increasing sequence means BOB wins
		{
			arr[r]=0;
			return 0;
		}
  Set<Integer> s = new HashSet<>();
  for(int i1=0;i1<n;i1++)
  {
      if(get1(r,i1)==1)
      {
          s.add(permu(a,n,unset(r,i1)));
      }

  }
  
  Iterator<Integer> iter = s.iterator();
  if(iter.next()==1)
	  arr[r] = 0;
  else
	  arr[r] =1;
  return arr[r];

	}

	private static int unset(int r, int i) {
		// TODO Auto-generated method stub
		return (r)&(~(1<<i));
	}

	private static int get1(int a, int i) {
		// TODO Auto-generated method stub
		return ((a&(1<<i))>>i);
	}
}
