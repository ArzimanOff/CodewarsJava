/*
https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java
*/

package com.codewars.arziman_off.kuy7;

import java.util.Arrays;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String strNum = String.valueOf(num);
        char[] charArr = strNum.toCharArray();
        Arrays.sort(charArr);
        StringBuilder newStr = new StringBuilder(new String(charArr)).reverse();
        return Integer.parseInt(String.valueOf(newStr));
    }

    public static void main(String[] args) {
        System.out.println(sortDesc(42145));     // 54421
        System.out.println(sortDesc(145263));    // 654321
        System.out.println(sortDesc(123456789)); // 987654321
    }
}