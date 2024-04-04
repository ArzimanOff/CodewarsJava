package com.leetcode.arziman_off.easy;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s;
        s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Глубина выражения " + s + " : "+ maxDepth(s));
        s = "(1)+((2))+(((3)))";
        System.out.println("Глубина выражения " + s + " : "+ maxDepth(s));
    }
    public static int maxDepth(String s) {
        int ans = 0;
        int depth = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                depth++;
            } else if (ch == ')'){
                ans = Math.max(ans, depth);
                depth--;
            }
        }
        return ans;
    }
}
