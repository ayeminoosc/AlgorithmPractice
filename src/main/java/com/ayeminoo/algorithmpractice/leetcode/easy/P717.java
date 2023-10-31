package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */
public class P717 {


    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length > 1 && bits[bits.length -1 ] == 0 && bits[bits.length - 2] == 0){
            return true;
        }
        int i = 0;
        boolean isFirstChar = false;
        while(i<bits.length){
            if(isFirstChar(bits, i)){
                isFirstChar = true;
                i++;
            }else if(isSecondChar(bits, i)){
                isFirstChar = false;
                i += 2;
            }else{
                throw new RuntimeException("wrong array");
            }
        }
        return isFirstChar;
    }

    private boolean isFirstChar(int[] bits, int index){
        return (bits[index] == 0) ? true: false;
    }

    private boolean isSecondChar(int[]bits, int index){
        int i = index;
        int j = i + 1;
        return ((bits[i] == 1 && bits[j] ==0) || (bits[i] == 1 && bits[j] == 1)) ? true : false;
    }
}
