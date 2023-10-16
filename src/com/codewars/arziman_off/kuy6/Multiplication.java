/*
https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08/train/java
*/

package com.codewars.arziman_off.kuy6;

public class Multiplication {
    public static int [][] multiplicationTable(int n){
        if (n < 0){
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        return matrix;
    }

    public static void printTable(int[][] table) {
        int space = String.valueOf(table.length * table.length).length() + 1;
        for (int[] ints : table) {
            for (int j = 0; j < ints.length; j++) {
                if (j != 0) {
                    System.out.printf("%" + space + "s", ints[j]);
                } else {
                    System.out.printf("%s", ints[j]);
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int n = 0; n < 6; n++){
            printTable(multiplicationTable(n));
            System.out.println();
        }
    }
}
