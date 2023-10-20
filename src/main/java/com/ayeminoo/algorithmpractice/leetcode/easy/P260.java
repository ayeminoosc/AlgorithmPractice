package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number-iii/description/
 */
public class P260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Boolean> firstTimeMap = new HashMap<>();
        for(int num: nums){
            if(firstTimeMap.get(num) == null){
                firstTimeMap.put(num, true);
            }else{
                firstTimeMap.put(num, false);
            }
        }
        int i = 0;
        int[] result = new int[2];
        for(Map.Entry<Integer, Boolean>entry: firstTimeMap.entrySet()){
            if(entry.getValue()){
                result[i++] = entry.getKey();
            }
            if(i == 2) return result;
        }

        return result;
    }
}
