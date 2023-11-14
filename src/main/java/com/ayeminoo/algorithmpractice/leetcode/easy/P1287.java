package com.ayeminoo.algorithmpractice.leetcode.easy;

public class P1287 {
    public int findSpecialInteger(int[] arr) {
        int maxCount = arr.length/4 ;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == arr[i+maxCount]) return arr[i];
        }
        return -1;
    }
    public static void main(String[]args){
        System.out.println(new P1287().findSpecialInteger(new int[]{1}));
    }
}
