package com.other_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class SortingByInserts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        insertsSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertsSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
