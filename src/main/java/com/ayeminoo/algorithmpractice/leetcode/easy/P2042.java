package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
 */
public class P2042 {
    public boolean areNumbersAscending(String s) {
        int i = Integer.MIN_VALUE;
        for(String word: s.split(" ")){
            try{
                int c = Integer.parseInt(word);
                if(c <= i) return false;
                i = c;
            }catch (NumberFormatException ex){

            }
        }

        return true;
    }
}
