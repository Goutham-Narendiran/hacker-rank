package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RestoreIPAddress1 {
public static void main(String...args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str = br.readLine();
	ArrayList<String> list = restoreIPAddress(str);
	for(String x : list)
		System.out.println(x);
}

private static ArrayList<String> restoreIPAddress(String s) {
	// TODO Auto-generated method stub
	ArrayList<String> ret = new ArrayList<>();
	String help = "";
	ipHelper(s, ret, help, 0, 4);
    return ret;
	
}

private static void ipHelper(String str, ArrayList<String> result, String strPre, int start, int num) {
	// TODO Auto-generated method stub
	 if (str.length() - start > num * 3 || str.length() - start < 0 || num < 0) return;
     if (num == 0) {
         strPre = strPre.substring(0,strPre.length()-1);
         result.add(strPre);
     }
     for (int i = 0, count = 0; i < 3 && i + start < str.length(); ++i) {
         count = count * 10 + str.charAt(i+start) - '0';
         if (count <= 255)  ipHelper(str, result, strPre + str.substring(start, start+i + 1) + ".", start + i + 1, num - 1);
         if (count == 0)  return;
     }
}
}
