package com.leetcode.arziman_off.easy;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        int ans = 0;
        int[] arr = new int[n];
        if (n > 1){
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            ans = arr[n-1];
        } else if (n == 1){
            ans = 1;
        }

        return ans;
    }

}
