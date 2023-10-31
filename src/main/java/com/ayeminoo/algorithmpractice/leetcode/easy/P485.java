package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class P485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        boolean isPreviousOne = false;
        int numOne = 0;
        for(int num: nums){
            if(num == 1){
                numOne ++;
                isPreviousOne=true;
            }else{
                if(isPreviousOne){
                    isPreviousOne = false;
                    max = Math.max(max, numOne);
                    numOne = 0;
                }
            }
        }
        max = Math.max(max, numOne);
        return max;
    }
}
