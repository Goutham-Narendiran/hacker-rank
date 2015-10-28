package com.interview.array;

public class parseLong {
	public static long parseLong1(String str){
		boolean isNegative = false;
		long length = str.length();
		long i =0;
		long number = 0;
		if(str.charAt((int) i)=='-'){
			isNegative = true;
			i++;
		}

		else if(str.charAt((int) i)=='+')
			i++;


		if(!str.substring((int)i).matches("^[0-9]+$")){
			NumberFormatException e = new NumberFormatException();
			throw e;
		}

		while(i<length){
			number*= 10;
			number+=(str.charAt((int)i++)-'0');
		}
		if(isNegative)
			number = -number;
		return number;

	}
	public static void main(String...args){
		System.out.println(parseLong1("123 "));
	}
}
