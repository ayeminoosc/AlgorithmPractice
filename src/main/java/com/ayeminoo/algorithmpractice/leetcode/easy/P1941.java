package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class P1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i<s.length() ;i++){
            char ch= s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        int count = -1;
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            if(count == -1){
                count = entry.getValue();
            }else{
                if(count != entry.getValue()) return false;
            }
        }

        return true;
    }
}
