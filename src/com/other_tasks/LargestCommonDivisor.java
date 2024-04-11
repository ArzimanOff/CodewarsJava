package com.other_tasks;

import java.util.Scanner;

public class LargestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(findLCD(A, B));
    }

    public static int findLCD(int A, int B){
        int ans = Math.min(A, B);
        if (ans <= 0) return 0;
        A = Math.max(A, B);
        B = ans;

        if (A - B != B){
            A -= B;
        } else {
            return B;
        }
        return findLCD(B, A);
    }
}
