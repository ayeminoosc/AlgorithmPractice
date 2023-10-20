package com.ayeminoo.algorithmpractice.leetcode.easy;

/**
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
 */
public class P2160 {
    private int minVal = Integer.MAX_VALUE;
    public int minimumSum(int num) {
        int a = num / 1000;
        int ar = num % 1000;
        int b = ar / 100;
        int br = ar % 100;
        int c = br / 10;
        int d = br % 10;
//        permute(new int[]{a, b, c, d}, new int[]{});
        heapPermutation(new int[]{a,b,c,d}, 4, 4);
        return minVal;
    }

    void heapPermutation(int a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            minVal = minSum(minVal, a);

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

    private void permute(int[] data, int[]prefix){
        if(data.length == 0){
            minVal = minSum(minVal, prefix);
        }

        for(int i = 0;i< data.length ; i++){
            int c = data[i];
            int[] needPermu = new int[data.length - 1];
            System.arraycopy(data, 0, needPermu, 0, i);
            System.arraycopy(data, i+1, needPermu, i, data.length - i -1);
            int[] tempPrefix = new int[prefix.length + 1];
            System.arraycopy(prefix, 0, tempPrefix, 0, prefix.length);
            tempPrefix[prefix.length] = c;
            permute(needPermu, tempPrefix);
        }
    }

    private int minSum(int currentMin, int[] data){
        int first = data[0] * 10 + data[1];
        int second = data[2] * 10 + data[3];
        return Math.min(currentMin, first + second);
    }
}
