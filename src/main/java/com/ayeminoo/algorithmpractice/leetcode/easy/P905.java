package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/sort-array-by-parity/description/
 */
public class P905 {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = result.length - 1;

        for(int num: nums){
            if(num%2 == 0){
                //even
                result[l++] = num;
            }else{
                //odd
                result[r--] = num;
            }
        }
        return result;
    }
}
