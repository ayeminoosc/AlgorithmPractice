package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class P594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(count.containsKey(entry.getKey() + 1)){
                max = Math.max(max, entry.getValue() + count.get(entry.getKey() +1));
            }
        }
        return max;
    }
}
