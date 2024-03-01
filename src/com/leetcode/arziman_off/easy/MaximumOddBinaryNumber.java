package com.leetcode.arziman_off.easy;

import java.util.Arrays;
import java.util.Map;

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("100101"));
    }

    // 1st realization
    public static String maximumOddBinaryNumber(String s) {
        int cnt1 = 0;
        int cnt0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt1++;
            else cnt0++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < cnt1 - 1; i++) ans.append('1');
        for (int i = 0; i < cnt0; i++) ans.append('0');
        return ans.append('1').toString();
    }

    // 2nd realization
//    public static String maximumOddBinaryNumber(String s) {
//        char[] chArr = s.toCharArray();
//        Arrays.sort(chArr);
//        StringBuilder ans = new StringBuilder();
//        for (int i = chArr.length - 2; i >= 0; i--){
//            ans.append(chArr[i]);
//        }
//        ans.append(chArr[chArr.length - 1]);
//        return ans.toString();
//    }
}
