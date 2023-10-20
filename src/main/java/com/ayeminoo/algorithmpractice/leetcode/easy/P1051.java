package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/description/
 *
 */
public class P1051 {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for(int i=0; i< heights.length; i++){
            if(expected[i]!= heights[i]) count++;
        }
        return count;
    }
}
