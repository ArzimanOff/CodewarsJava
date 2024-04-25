package com.other_tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProcessingOfApplications {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();;
        while (n != 0){
            int i = sc.nextInt();
            int k = sc.nextInt();
            if (i == 1){
                numbers.add(k);
                numbers.sort(Collections.reverseOrder());
            } else if (i == 0) {
                System.out.println(numbers.get(k - 1));
            } else if (i == -1) {
                int ok = 0;
                int j = 0;
                while (ok == 0){
                    if (numbers.get(j) == k){
                        numbers.remove(j);
                        ok = 1;
                    }
                    j++;
                }
            } else {
                System.out.println("неверный ввод");
            }
            n--;
        }
    }
}
