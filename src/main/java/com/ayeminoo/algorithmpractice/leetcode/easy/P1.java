package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) return new int[]{i, map.get(diff)};
            map.put(nums[i], i);
        }
        return null;
    }
}
