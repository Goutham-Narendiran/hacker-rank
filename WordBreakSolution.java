package com.interview.array;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class WordBreak{
	static String[] dictionary = {"i","like","peanut","butter","pea","nut","study","university","at","the","and"};
    List<String> dict = Arrays.asList(dictionary);
	static Stack<String> sentence = new Stack<>();
	int wb[];
	int x=0,y=0;
	
	boolean recursiveWordBreakSol(String str){
		
		if(str.length() == 0 )
			return true;
		if(dict.contains(str))
			{
			   sentence.push(str);
			   return true;
			}
		for(int i=0; i< str.length();i++){
			String prefix = str.substring(0,i);
			String suffix = str.substring(i);
			if((dict.contains(prefix) && recursiveWordBreakSol(suffix))){
				sentence.push(prefix);
				return true;
			}
		}
		return false;
	}
	
	boolean dynamicWordBreakSol(String str){
		
		if(str.length() == 0)
			return true;
		
		wb = new int[str.length()+1];
		Arrays.fill(wb,0);
		
		for(int i=1;i<=str.length();i++)
		{
			x++;
			if(wb[i]==0 && dict.contains(str.substring(0,i)))
				wb[i]++;
			
			if(wb[i]>0){
				if(i==str.length())
					return true;
				for(int j=i+1;j<=str.length();j++)
				{
					y++;
					if((wb[j]==0||wb[j]>0) && dict.contains(str.substring(i,j)))
						wb[j]++;
					
					if(j==str.length() && wb[j]>0)
						return true;
						
				}
			}
		}
		return false;
		
	}
	
	
	
	void printStackRecursive(){
		while(!sentence.isEmpty())
			System.out.print(sentence.pop()+" ");
	}
	
	void printDynamic(String str){
		
		int skip =0;
		   for(int i =str.length()-1;i>=0;i--){
		    	
		    	
		    	if(wb[i]>0){
		    		if(skip==0)
		    		{
		    			skip = wb[i];
		    			sentence.push(" "+str.charAt(i));
		    			
		    		}
		    		else
		    			
		    			sentence.push(String.valueOf(str.charAt(i)));
		    			
		    		skip--;
		    			
		    		
		    		
		    	}
		    	
		    	else
		    	{
		    		sentence.push(String.valueOf(str.charAt(i)));
		    	}
		    		
		    	
		    }
		   
		   while(!sentence.isEmpty())
				System.out.print(sentence.pop());
	}
}
public class WordBreakSolution {
	
	public static void main(String...args){
		String sentence = "ilikepeanutbutterstudyattheuniversityandatthepea";
//		boolean pos;
		
//		if((pos = obj.recursiveWordBreakSol(sentence.toLowerCase())==true))
//			obj.printStack();
//		else
//			System.out.println(false);
//			
		
		    WordBreak obj = new WordBreak();
			obj.dynamicWordBreakSol(sentence);
		    obj.printDynamic(sentence);
		   
	}

}

