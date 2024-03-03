package com.leetcode.arziman_off.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {

    }
    public static int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            ans.add(digits[i] + carry);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
