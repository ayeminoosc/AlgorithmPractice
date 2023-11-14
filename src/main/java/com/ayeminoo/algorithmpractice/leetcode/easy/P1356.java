package com.ayeminoo.algorithmpractice.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
public class P1356 {
    public static void main(String[]args){
        int r = Integer.bitCount(7);
        System.out.println(r);
        int[] arr =  new int[]{0,1,2,3,4,5,6,7,8};
        quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (isLower(arr[j], pivot)) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static boolean isLower(int a, int b){
        int bita = Integer.bitCount(a);
        int bitb = Integer.bitCount(b);
        if(bita == bitb){
            return a < b;
        }else return bita < bitb;
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int[] sortByBits(int[] arr) {
       quickSort(arr, 0, arr.length -1);
       return arr;
    }
}
