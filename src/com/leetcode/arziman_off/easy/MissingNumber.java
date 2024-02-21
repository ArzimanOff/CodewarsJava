package com.leetcode.arziman_off.easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] intArr = new int[]{6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(intArr));
    }
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int realSum = len * (len + 1) / 2;
        int thisSum = 0;
        for (int num : nums) {
            thisSum += num;
        }
        return realSum - thisSum;
    }
}
