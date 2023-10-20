package com.ayeminoo.algorithmpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public void printString(String text, String prefix){
        if(text.equals("")){
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i<text.length(); i++){
            char ch = text.charAt(i);
            String remaining = text.substring(0, i) + text.substring(i+1);
            printString(remaining, prefix + ch);
        }
    }

    public void permuteArray(int[]data, int[]prefix,  List<int[]> result){
        if(data.length == 0){
            result.add(prefix);
            return;
        }

        for(int i = 0;i< data.length ; i++){
            int c = data[i];
            int[] needPermu = new int[data.length - 1];
            System.arraycopy(data, 0, needPermu, 0, i);
            System.arraycopy(data, i+1, needPermu, i, data.length - i -1);
            int[] tempPrefix = new int[prefix.length + 1];
            System.arraycopy(prefix, 0, tempPrefix, 0, prefix.length);
            tempPrefix[prefix.length] = c;
            permuteArray(needPermu, tempPrefix, result);
        }
    }

    void printArr(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    void heapPermutation(int a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(a, n);

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


    public static void main(String[]args){
        Permutation permutation = new Permutation();
//        permutation.printString("abcd", "");

//        List<int[]> result = new ArrayList<>();
//        permutation.permuteArray(new int[]{1,2,3}, new int[]{}, result);
//
//        for(int[] iArray: result){
//            System.out.println(Arrays.toString(iArray));
//        }

        int a[] = { 1, 2, 3 };
        permutation.heapPermutation(a, a.length, a.length);
//        permutation.generate(3, new char[]{'a', 'b', 'c'});

    }


    public void generate(int k, char[]array){
        if(k==1)
            System.out.println(Arrays.toString(array));
        else {
            generate(k-1, array);
            for(int i=0; i<k-1; i++){
                if(k%2 == 0){
                    char ch = array[k-1];
                    array[k-1] = array[i];
                    array[i] = ch;
                }else{
                    char ch = array[k-1];
                    array[i-1] = array[0];
                    array[0] = ch;
                }
                generate(k-1, array);
            }
        }
    }
}
