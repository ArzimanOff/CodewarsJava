package com.leetcode.arziman_off.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
    public static int lengthOfLastWord(String s) {
        String cleanedStr = s.trim();
        int len = 0;
        int lastIndex = cleanedStr.length() - 1;
        for (int i = lastIndex; i >= 0; i--){
            if(cleanedStr.charAt(i) != ' '){
                len++;
            } else {
                break;
            }
        }
        return len;
    }
}
