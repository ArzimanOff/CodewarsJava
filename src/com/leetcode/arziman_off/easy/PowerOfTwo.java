package com.leetcode.arziman_off.easy;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println("isPowerOfTwo:");
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(45));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(64));

        System.out.println("\nisPowerOfTwoFaster:");
        System.out.println(isPowerOfTwoFaster(2));
        System.out.println(isPowerOfTwoFaster(4));
        System.out.println(isPowerOfTwoFaster(45));
        System.out.println(isPowerOfTwoFaster(0));
        System.out.println(isPowerOfTwoFaster(64));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n < 0){
            return false;
        }
        String str = Integer.toBinaryString(n);
        char[] arr = str.toCharArray();
        int cnt = 0;
        for (char ch : arr) {
            if (ch == '1') {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static boolean isPowerOfTwoFaster(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

}
