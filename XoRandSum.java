package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XoRandSum {
	
	private static final int MOD = 1000000007;
	private static final int MAX = 5;
	
public static void main(String...args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	byte [] A = toByteArray(br.readLine().toCharArray()); 
    byte [] B = toByteArray(br.readLine().toCharArray());
    
    A = reverse(A);
    B = reverse(B);
    if(A.length>B.length)
    	B = extend(B,A.length);
    else
    	A = extend(A,B.length);
    int len = A.length;
    long sum = 0L;
    long pow = 1L;
    int i=0,oneCount = 0;
    for(i=0;i<len;i++){
    	oneCount+= B[i];
    	int multiplier = (A[i]==0) ? oneCount : MAX - oneCount +1;
    	sum = (sum + pow*multiplier)%MOD;
    	pow = (pow<<1L)%MOD;	
    }
    
    while(i<MAX){
    	i++;
    	sum = (sum + pow*oneCount)%MOD;
    	pow = (pow<<1L)%MOD;	
    }
    
    for(int i1 = 0;i1<len;i1++){
    	sum = (sum + pow*oneCount)%MOD;
    	pow = (pow<<1L)%MOD;
    	oneCount-= B[i1];
    }
    
    System.out.println(sum);
}

private static byte[] extend(byte[] arr, int length) {
	// TODO Auto-generated method stub
	return Arrays.copyOf(arr, length);
}

private static byte[] reverse(byte[] a) {
	// TODO Auto-generated method stub
    byte[] temp = new byte[a.length];
    int i=0;
    for(int j=a.length-1;j>=0;j--)
    	temp[i++] = a[j];
   return temp;
}

private static byte[] toByteArray(char[] charArray) {
	// TODO Auto-generated method stub
	byte[] arr = new byte[charArray.length];
	int i =0;
	for(char x : charArray)
		arr[i++] = (byte) (x-'0');
	return arr;
}
}
