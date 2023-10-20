package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
public class P434 {
    public int countSegments2(String s) {
        return (int) Arrays.stream(s.split(" ")).filter(c-> !c.trim().equals("")).count();
    }

    public int countSegments(String s) {
        boolean sawChar = false;
        int wordCount = 0;
        for(int i=0; i< s.length();i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                sawChar = true;
            }else{
                if(sawChar){
                    wordCount++;
                    sawChar = false;
                }
            }
        }
        if(sawChar)wordCount++;
        return wordCount;
    }

    public static void main(String[]args){
        System.out.println(new P434().countSegments(""));
    }
}
