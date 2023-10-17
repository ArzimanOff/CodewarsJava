/*
https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/java
*/

package com.codewars.arziman_off.kuy7;

public class Accumul {
    public static String accum(String s) {
        StringBuilder ans = new StringBuilder();
        char[] charsArr = s.toCharArray();
        for (int i = 0; i < charsArr.length; i++){
            for (int j = 0; j < i+1; j++){
                if (j == 0){
                    ans.append(String.valueOf(charsArr[i]).toUpperCase());
                } else {
                    ans.append(String.valueOf(charsArr[i]).toLowerCase());
                }
            }
            if (i != charsArr.length - 1){
                ans.append("-");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
        System.out.println(accum("cwAt"));
    }
}