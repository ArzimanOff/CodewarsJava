/*
https://www.codewars.com/kata/57eae20f5500ad98e50002c5/train/java
*/

package com.codewars.arziman_off.kuy8;

public class RemoveStringSpaces {
    public static void main(String[] args) {
        System.out.println(noSpace("8 j 8   mBliB8g  imjB8B8  jl  B")); // Output: "8j8mBliB8gimjB8B8jlB"
        System.out.println(noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd")); // Output: "88Bifk8hB8BB8BBBB888chl8BhBfd"
        System.out.println(noSpace("8aaaaa dddd r     ")); // Output: "8aaaaaddddr"
    }
    public static String noSpace(final String x) {
        return x.replaceAll(" ", "");
    }
}
