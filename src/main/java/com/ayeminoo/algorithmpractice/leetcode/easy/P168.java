package com.ayeminoo.algorithmpractice.leetcode.easy;

public class P168 {
    public String convertToTitle(int columnNumber) {
        int reminder = 0;
        int result = columnNumber;
        StringBuffer buffer = new StringBuffer();
        while(result > 26) {
            reminder = result % 26;
            result = result / 26;
            if (reminder == 0) {
                buffer.append('Z');
                result -= 1;
            } else {
                buffer.append((char) (reminder + 64));
            }
        }
        buffer.append((char) (result + 64));

        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new P168().convertToTitle(52));
    }
}
