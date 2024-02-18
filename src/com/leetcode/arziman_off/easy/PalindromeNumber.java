package com.leetcode.arziman_off.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12353));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(-0));
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        for (int i = 0; i < n/2; i++){
            if (s.charAt(i) != s.charAt(n - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
