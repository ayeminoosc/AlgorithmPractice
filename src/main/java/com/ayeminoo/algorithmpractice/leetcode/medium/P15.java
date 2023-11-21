package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/description/
 */
public class P15 {
    public static void main(String[]args){
        System.out.println(new P15().threeSum(new int[]{-1,0,1,0}));
    }
//
//    Map<Integer, Integer> countMap;
//    public void init(int[] nums){
//        countMap = new HashMap<>();
//        for(int num: nums){
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//    }
//
//    public List<List<Integer>> threeSum(int[] nums) {
//        init(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        Map<String, Boolean> map = new HashMap<>();
//        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
//            int diff = 0 - entry.getKey();
//            if(entry.getKey() == 0 && entry.getValue()>=3){
//                LinkedList<Integer> pair = new LinkedList<>();
//                pair.add(0);
//                pair.add(0);
//                pair.add(0);
//                if(map.get("00") == null){
//                    map.put("00", true);
//                    result.add(pair);
//                }
//
//            }else if(entry.getKey() != 0){
//                List<LinkedList<Integer>> twoSumR = twoSum(countMap, diff, entry.getKey());
//                for(LinkedList<Integer> temp: twoSumR){
//                    temp.addFirst(entry.getKey());
//                    Collections.sort(temp);
//                    if(map.get(temp.get(0) + "" + temp.get(2)) == null){
//                        map.put(temp.get(0) + ""+ temp.get(2), true);
//                        result.add(temp);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    List<LinkedList<Integer>> twoSum(Map<Integer, Integer> countMap, int target, int currentNum){
//        List<LinkedList<Integer>> result = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
//            if(entry.getKey() == currentNum && entry.getValue()<2) continue;
//            int diff = target - entry.getKey();
//            if(diff == currentNum && countMap.get(currentNum)<2) continue;
//            if(entry.getKey() == diff && entry.getValue()>=2) {
//                LinkedList<Integer> pair = new LinkedList<>();
//                pair.add(diff);
//                pair.add(diff);
//                result.add(pair);
//            }else if(entry.getKey() != diff && countMap.get(diff) != null){
//                LinkedList<Integer> pair = new LinkedList<>();
//                pair.add(entry.getKey());
//                pair.add(diff);
//                result.add(pair);
//            }
//        }
//        return result;
//    }



    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] nums;
    public List<List<Integer>> threeSum(int[] nums) {
        init(nums);
        Map<String, List<Integer>> tempMap = new HashMap<>();
        for(int i = 0; i<nums.length ;i++){
            int num = nums[i];
            List<LinkedList<Integer>> twoS = twoSum(-1 * num, i);
            for(LinkedList<Integer> ll: twoS){
                if(ll != null) {
                    ll.addFirst(num);
                    Collections.sort(ll);
                    tempMap.put(ll.get(0) + " "+ ll.get(2), ll);
                }
            }

        }
        return map.values().stream().toList();
    }

    void init(int[]nums){
        this.nums = nums;
        for(int i=0;i < nums.length ;i++){
            int num = nums[i];
            List <Integer> temp = map.getOrDefault(num, new ArrayList<>());
            temp.add(i);
            map.put(num, temp);
        }
    }
    public List<LinkedList<Integer>> twoSum(int target, int fromIndex) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        for(int i=fromIndex + 1; i<nums.length ;i ++){
            int num = nums[i];
            int gapNum = target - num;
            List<Integer> temp = map.get(gapNum);
            if(temp != null) {
                for(int index: temp){
                    if(index > fromIndex && index > i){
                        LinkedList<Integer> twoSumR  = new LinkedList<>();
                        twoSumR.add(num);
                        twoSumR.add(nums[index]);
                        result.add(twoSumR);
                    }
                }
            }
        }
        return result;
    }


}
