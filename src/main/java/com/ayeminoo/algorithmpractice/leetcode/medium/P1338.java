package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/description/
 */
public class P1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val: arr){
            map.put(val, map.getOrDefault(val,0) + 1);
        }
        List<Integer> integerSet = new ArrayList<>(map.values());
        Collections.sort(integerSet);
        int count = 0;
        int half = arr.length /2;
        Integer totalCount = 0;
        for(int i = integerSet.size() -1; i>=0; i--){
            count++;
            totalCount = totalCount + integerSet.get(i);
            if(totalCount>=half) break;
        }
        return count;
    }

    public  static void main(String[]args){
        System.out.println( new P1338().minSetSize(new int[]{1,9}));
    }
}
