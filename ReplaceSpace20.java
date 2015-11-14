package com.interview.array;

public class ReplaceSpace20 {
public static void main(String...args){
	 char[] array = {'a','b','c','d',' ','e','f','g',' ','h',' ','j'};
	    System.out.println(replaceSpaceInString(array, array.length));
}

private static char[] replaceSpaceInString(char[] array, int length) {
	// TODO Auto-generated method stub
	int spaceCount = 0;
	for(int i =0;i<length;i++)
		if(array[i]==' ')
			spaceCount++;
	char newArr[] = new char[length + 2*spaceCount+1];
	int newLength = 0;
	newArr[length + 2*spaceCount] = '\0';
	for(int i =0;i<length;i++){
		if(array[i]==' '){
			newArr[newLength] = '%';
			newArr[newLength+1] = '2';
			newArr[newLength+2] = '0';
			newLength+=3;
		}
		else
		{
			newArr[newLength] = array[i];
			newLength++;
		}
	}
	
	return newArr;
}
}
