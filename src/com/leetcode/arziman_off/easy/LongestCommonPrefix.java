package com.leetcode.arziman_off.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"abcd","abce","abcdr"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return ans.toString();
                }
            }
            ans.append(strs[0].charAt(i));
        }

        return ans.toString();
    }
}
