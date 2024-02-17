// https://leetcode.com/problems/replace-all-digits-with-characters/description/

package com.leetcode.arziman_off.easy;

import java.util.Scanner;

public class ReplaceAllDigitsWithCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(replaceDigits(s));
    }

    public static String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();
        char[] stringArr = s.toCharArray();
        for (int i = 0; i < stringArr.length; i++){
            // если позиция символа нечетная:
            if (((i+1) & 1) == 1){
                // это буква:
                ans.append(stringArr[i]);
            } else {
                // это число
                int ch = stringArr[i-1];
                int shift = Integer.parseInt(String.valueOf(stringArr[i]));
                ans.append( (char)(ch + shift) );
            }
        }
        return ans.toString();
    }
}
