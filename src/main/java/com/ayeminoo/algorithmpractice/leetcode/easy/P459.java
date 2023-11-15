package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 */

public class P459 {

    public boolean repeatedSubstringPattern(String s){
        if (s.length() == 1) return false;
        if(s.length() == 2) return s.charAt(0) == s.charAt(1);
        String temp = s + s;
        String check = temp.substring(1, temp.length()-2);
        if(check.contains(s)){
            return true;
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String text) {
        int len = text.length();
        if (len == 1) return false;
        int s = 0;
        int e = 1;
        while (e <= len / 2) {
            if(!check(text, e-s, e)){
                e++;
            }else{
                return true;
            }
        }
        return false;
    }

    boolean check(String text, int len, int start) {
        if (start + len > text.length()) return false;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != text.charAt(start + i)) return false;
        }
        if(start + len == text.length()) return true;
        return check(text, len, start + len);
    }

    public static void main(String[] args) {
//        System.out.println(new P459().check("aba", 2, 2));
        System.out.println(new P459().repeatedSubstringPattern("bb"));
    }
}
