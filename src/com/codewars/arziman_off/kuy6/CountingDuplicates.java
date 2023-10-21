package com.codewars.arziman_off.kuy6;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        int cnt = 0;
        int[] charCount  = new int[126-33];
        text = text.toLowerCase();
        for (char ch : text.toCharArray()) {
            if (ch >= 33 && ch <= 126) {
                if (charCount[ch - 33] == 1) {
                    cnt++;
                }

                charCount[ch - 33]++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(duplicateCount("ABBA"));
        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("aabbcde"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("aA11"));
    }
}
