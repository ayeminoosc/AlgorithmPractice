package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class P646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] ;
            }
        });

        print(pairs);

        int count = 1;

        int [] pair = pairs[0];

        for(int i =1 ;i <pairs.length ;i++){
            if(pair[1]< pairs[i][0]){
                count++;
                pair = pairs[i];
            }
        }

        return count;
    }

    void print(int[][]pairs){
        System.out.print("[");
        for(int[]p: pairs){
            System.out.print("["+p[0]+ ", " + p[1] + "], ");
        }
        System.out.println("]");
    }


    public static void main(String[]args){
        System.out.println(new P646().findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
    }
}
