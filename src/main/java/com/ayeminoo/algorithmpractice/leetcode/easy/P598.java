package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/range-addition-ii/
 */
public class P598 {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m * n;

        int sl = Integer.MAX_VALUE;
        int sr = Integer.MAX_VALUE;
        for(int[] op: ops){
            sl = Math.min(sl, op[0]);
            sr = Math.min(sr, op[1]);
        }

        return sl * sr;

    }
}
