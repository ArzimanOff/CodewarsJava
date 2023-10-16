/*
https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/java
*/
package com.codewars.arziman_off.kuy7;

class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int startNumber = (n * n) - (n - 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += startNumber + 2 * i;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(1));
        System.out.println(rowSumOddNumbers(2));
        System.out.println(rowSumOddNumbers(3));
    }
}