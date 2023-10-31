package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/detect-capital/description/
 */
public class P520 {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))){
            return isAllSmall(word, 1);
        }else{
            return isAllSmall(word, 1) || isAllCap(word, 1);
        }
    }

    public boolean isAllSmall(String word, int index){
        while(index<word.length()){
            if(!Character.isLowerCase(word.charAt(index))) return false;
            index++;
        }
        return true;
    }

    public boolean isAllCap(String word, int index){
        while(index<word.length()){
            if(!Character.isUpperCase(word.charAt(index))) return false;
            index++;
        }
        return true;
    }
}
