package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Triplets{
	int a,b,c;
	String s;
	Triplets(int a,int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
		s = String.valueOf(a)+String.valueOf(b)+String.valueOf(c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + s.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
            return false;
		final Triplets t = (Triplets) obj;
		if(t.a == a && t.b == b && t.c == c)
			return true;
		return false;

	}
}

public class ThreeSum {
	public static void main(String[] args) {
		int arr[] = {-1,0,1,2,-1,-4};
		sovle(arr);
	}

	private static List<List<Integer>> sovle(int[] arr) {
		
		// TODO Auto-generated method stub
		List<List<Integer>> l = new ArrayList<>();
		if(arr==null || arr.length<3)
			return l;
		Arrays.sort(arr);
		Set<Triplets> s = new HashSet<>();
		int i,j,k;
		for(i = 0;i<arr.length-2;i++){
			for(j = i+1,k = arr.length-1;j<k;){
				if(arr[j]+arr[k]==(-1*arr[i])){
					s.add(new Triplets(arr[i],arr[j],arr[k]));
					j++;k--;
				}
					
				else if(arr[j]+arr[k]<(-1*arr[i]))
					j++;
				else
					k--;
			}
		}
				
		for(Triplets x : s){
			List<Integer> t = new ArrayList<>();
			t.add(x.a);
			t.add(x.b);
			t.add(x.c);
			l.add(t);
		}
		
		return l;
		
	}
}
