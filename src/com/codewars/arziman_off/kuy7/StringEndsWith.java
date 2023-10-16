/*
Условие задания:
https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d/train/java
*/

package com.codewars.arziman_off.kuy7;
public class StringEndsWith {
    public static boolean solution(String str, String ending) {
        if (str != null && ending != null){
            return str.endsWith(ending);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // returns true
        System.out.println(solution("abc", "d")); // returns false
    }
}
