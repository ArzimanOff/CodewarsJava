package com.leetcode.arziman_off.easy;

import java.util.*;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String newS = makeGood(s);
        System.out.println("Преобразованная строка : \"" + newS + "\"");
    }
    public static String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
