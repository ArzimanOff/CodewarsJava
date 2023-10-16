/*
https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java
*/

package com.codewars.arziman_off.kuy6;

public class PersistentBugger {
    public static int persistence(long n) {
        int cnt = 0;
        while (n >= 10) {
            n = multiplicationOfDigits(n);
            cnt++;
        }
        return cnt;
    }

    public static long multiplicationOfDigits(long n) {
        long product = 1L;

        while (n > 0) {
            product *= n % 10;
            n /= 10;
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(persistence(25));
        System.out.println(persistence(39));
        System.out.println(persistence(999));
        System.out.println(persistence(4));
    }
}
