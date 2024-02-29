package com.leetcode.arziman_off.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> romanValues  = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] chArray = s.toCharArray();
        char preChar = ' ';
        for (int i = chArray.length - 1; i >= 0; i--) {
            if (chArray[i] == 'I'){
                ans += (preChar == 'V' || preChar == 'X') ? (-1) : (1);
            } else if (chArray[i] == 'X'){
                ans += (preChar == 'L' || preChar == 'C') ? (-10) : (10);
            } else if (chArray[i] == 'C'){
                ans += (preChar == 'D' || preChar == 'M') ? (-100) : (100);
            } else {
                ans += romanValues.get(chArray[i]);
            }
            preChar = chArray[i];
        }

        return ans;
    }
}
