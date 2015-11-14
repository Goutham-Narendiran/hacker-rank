package com.interview.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SaveQuantumland {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int a[] = new int[n];
            int prev = 1;
            int count=0;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if(prev==0&&a[a_i]==0){
                	count++;
                	prev=1;
                }
                else{
                	prev = a[a_i];
                }
            }
            
            System.out.println(count);
        }
    }
}
