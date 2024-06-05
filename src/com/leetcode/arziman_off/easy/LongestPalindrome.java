package com.leetcode.arziman_off.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(longestPalindrome(s));
    }
    static public int longestPalindrome(String s) {
        int ans = 0;
        int flag = 0;

        Map<Character, Integer> charsCnt = new HashMap<>();

        for (char ch : s.toCharArray()){
            if (!charsCnt.containsKey(ch)){
                charsCnt.put(ch, 1);
            } else {
                charsCnt.put(ch, charsCnt.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charsCnt.entrySet()){
            int n = entry.getValue();
            if (n % 2 != 0){
                flag = 1;
                ans += (n - 1);
            } else {
                ans += n;
            }
        }
        return (flag == 0) ? ans : ans + 1;
    }
}
