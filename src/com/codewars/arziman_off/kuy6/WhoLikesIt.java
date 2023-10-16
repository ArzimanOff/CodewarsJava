/*
https://www.codewars.com/kata/5266876b8f4bf2da9b000362/train/java
*/

package com.codewars.arziman_off.kuy6;
public class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        if (names == null) {
            return "no one likes this";
        }
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> String.format("%s likes this", names[0]);
            case 2 -> String.format("%s and %s like this", names[0], names[1]);
            case 3 -> String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default -> String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        };
    }

    public static void main(String[] args) {
        System.out.println(whoLikesIt());
        System.out.println(whoLikesIt("Alex"));
        System.out.println(whoLikesIt("Alex", "Jacob"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
