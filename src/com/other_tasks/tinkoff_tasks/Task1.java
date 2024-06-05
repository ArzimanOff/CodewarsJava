package com.other_tasks.tinkoff_tasks;

import java.util.Scanner;

public class Task1 {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int A, B, C, D;
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        D = scanner.nextInt();

        if (D > B){
            System.out.println(A + ((D-B) * C));
        } else {
            System.out.println(A);
        }
    }
}

