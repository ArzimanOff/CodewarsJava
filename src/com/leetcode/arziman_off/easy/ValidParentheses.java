package com.leetcode.arziman_off.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("(){){]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("("));
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s) {
        if (s == null || (s.length() & 1) == 1){
            return false;
        } else {
            char[] chArray = s.toCharArray();
            Deque<Character> deque = new ArrayDeque<>();
            for (char ch:
                 chArray) {
                if (ch == '(' || ch == '{' || ch == '['){
                    deque.push(ch);
                } else {
                    if (deque.isEmpty()){
                        return false;
                    } else {
                        if (ch == ')' && deque.peekFirst() == '(' ||
                                ch == '}' && deque.peekFirst() == '{' ||
                                ch == ']' && deque.peekFirst() == '['){
                            deque.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
            return deque.isEmpty();
        }
    }

    // 2nd variant
//    public static boolean isValid(String s) {
//        if (s == null || (s.length() & 1) == 1){
//            return false;
//        } else {
//            while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
//                s = s.replaceAll("\\(\\)", "")
//                        .replaceAll("\\[\\]", "")
//                        .replaceAll("\\{\\}", "");
//            }
//            return (s.isEmpty());
//        }
//    }
}
