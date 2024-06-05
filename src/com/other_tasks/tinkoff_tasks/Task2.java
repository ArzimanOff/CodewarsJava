package com.other_tasks.tinkoff_tasks;

import java.util.Scanner;

public class Task2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        System.out.println(getCutCount(N));
    }

    private static int getCutCount(int n) {
        if (n == 1){
            return 0;
        } else if ((n & (n-1)) == 0){
            n--;
        }
        return (Integer.toBinaryString(n)).length();
    }
}
