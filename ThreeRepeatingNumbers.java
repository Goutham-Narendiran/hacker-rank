package com.interview.array;

public class ThreeRepeatingNumbers {
public static void main(String...args){
	int arr[] = {3,3,2,3};
	int ones=0;
	int twos=0;
	int common_bits;
	for(int i=0;i<arr.length;i++){
		twos = twos|(ones&arr[i]);
		ones = ones^arr[i];
		common_bits = ~(ones&twos);
		ones = ones&common_bits;
		twos= twos&common_bits;
	}
	
	System.out.println(ones);
//	int x = 12;
//	int ans = x - (x &(-x));
	System.out.println(ones);
	
}
}
