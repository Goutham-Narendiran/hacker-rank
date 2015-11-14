package com.interview.array;

import java.util.Stack;

public class CountingBrackets {
	public static void main(String...args){
		String par = "))))";
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int i =-1;
		int j;
		int result = 0;
		while(++i<par.length()){
			if(par.charAt(i)==')'){
				j=stack.pop();
				if(!stack.isEmpty())
					result = Math.max(result, i-stack.peek());
				else
					stack.push(i); 
			}
			else
				stack.push(i);
		}

		System.out.println(result);
	}
}
