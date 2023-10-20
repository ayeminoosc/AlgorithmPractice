package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/separate-the-digits-in-an-array/description/
 */
public class P2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            result.addAll(split(num));
        }

        int [] r = new int[result.size()];
        for(int i=0; i< result.size(); i++){
            r[i] = result.get(i);
        }
        return r;
    }

    List<Integer> split(int num){
        List<Integer> result = new ArrayList<>();
        int r;
        do{
            r = num / 10;
            result.add(num % 10);
            num = r;
        }while(r > 0);
        revlist(result);
        return result;
    }

    public static <T> void revlist(List<T> list)
    {
        // base condition when the list size is 0
        if (list.size() <= 1 || list == null)
            return;


        T value = list.remove(0);

        // call the recursive function to reverse
        // the list after removing the first element
        revlist(list);

        // now after the rest of the list has been
        // reversed by the upper recursive call,
        // add the first value at the end
        list.add(value);
    }


}