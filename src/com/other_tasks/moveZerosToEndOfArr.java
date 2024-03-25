package com.other_tasks;
import java.util.Scanner;

public class moveZerosToEndOfArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = moveZerosToEnd(arr, n);

        for (int grade : result) {
            System.out.print(grade + " ");
        }
    }

    public static int[] moveZerosToEnd(int[] array, int n) {
        int left = 0;

        for (int i = 0; i < n; i++) {
            if (array[left] == 0) {
                // Сдвигаем нулевой элемент в конец массива
                int temp = array[left];
                for (int j = left; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = temp;
            } else {
                left++;
            }
        }
        return array;
    }
}



