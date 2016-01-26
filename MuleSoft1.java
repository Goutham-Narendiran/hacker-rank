package com.interview.array;

public class MuleSoft1 {
public static void main(String[] args) {
	System.out.println(solve(123,0));
}

private static int solve(int A,int B) {
	// TODO Auto-generated method stub
    String s1 = String.valueOf(A);
    String s2 = String.valueOf(B);
    String output = "";
    long max = 100000000;
    
    if(A<0||A>max)
    	return -1;
    if(B<0||B>max)
    	return -1;
    
    for(int i=0;i<s1.length()||i<s2.length();i++){
    	if(i<s1.length())
    		output += s1.charAt(i);
    	if(i<s2.length())
    		output += s2.charAt(i);
    }
    
    if(Long.parseLong(output)>max)
    	return -1;
    return Integer.parseInt(output);
    
    
}
}
