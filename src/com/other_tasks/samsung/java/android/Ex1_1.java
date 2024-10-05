package com.other_tasks.samsung.java.android;

import java.util.Scanner;

public class Ex1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);

        int sum = A + B;

        System.out.println(sum);

        scanner.close();
    }
}