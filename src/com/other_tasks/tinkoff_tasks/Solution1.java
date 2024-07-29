package com.other_tasks.tinkoff_tasks;

import java.util.Scanner;

public class Solution1 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        int[][] numbers; // Массив
        n = scanner.nextInt();
        numbers = fillArray(n);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, numbers))
                    res++;
            }
        }

        System.out.println("Введенный массив: ");
        printArray(numbers);

        System.out.println("Ответ: ");
        System.out.println(res);

    }

    public static boolean check(int i, int j, int[][] arr) {
        boolean ok = false;
        int rowSum = rowSum(i, arr);
        int colSum = colSum(j, arr);
        int x = arr[i][j];
        if (Math.abs(rowSum - colSum) <= x){
            ok = true;
        }
        return ok;
    }

    public static int rowSum(int i, int[][] arr){
        int sum = 0;
        int size = arr.length;
        for (int j = 0; j < size; j++) {
            sum += arr[i][j];
        }
        return sum;
    }
    public static int colSum(int j, int[][] arr){
        int sum = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            sum += arr[i][j];
        }
        return sum;
    }

    public static int[][] fillArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }



    public static void printArray(int[][] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//1 1 4  3 = 9
//1 2 9  2 = 14
//1 4 2  1 = 8
//5 2 1  3 = 11
//---------
//8 9 16 9