package com.interview.array;

import java.io.IOException;
import java.util.regex.Pattern;
public class ValidNumber {
    public boolean isNumber(String s) throws IOException {
        String pattern1 = "[+-]?[0-9]+\\.?[0-9]+$";
        String pattern2 = "[+-]?[0-9]+$";
        String pattern3 = "[+-]?\\.?[0-9]+$";
        String pattern4 = "[+-]?[0-9]+\\.?$";
        String pattern5 = "[+-]?[0-9]*\\.e[1-9]*[0-9]+$";
        String pattern6 = "[+-]?[0-9]+\\.?[0-9]*e[0-9]*\\.?[0-9]+$";
       // String pattern7 = "\\.e[0-9]*\\.?[0-9]+$";
        //Pattern p = Pattern.compile(pattern);
        if(s.trim().matches(pattern1)||s.trim().matches(pattern2)||s.trim().matches(pattern3)||s.trim().matches(pattern4)||s.trim().matches(pattern5)||s.trim().matches(pattern6))
        return true;
        else
        return false;
    }
}