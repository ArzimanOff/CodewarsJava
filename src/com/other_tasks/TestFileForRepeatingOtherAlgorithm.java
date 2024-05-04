package com.other_tasks;

import java.util.Arrays;
import java.util.Scanner;


public class TestFileForRepeatingOtherAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr.length != 0) {
            quickSortFunc(arr, 0, arr.length - 1);
        }
    }

    public static void quickSortFunc(int [] arr, int left, int right){
        int i = left;
        int j = right;
        int pivotIndex = i + (j - i) / 2;
        int pivot = arr[pivotIndex];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot){
                j--;
            }
            if (i <= j){
                swapElements(arr, i++, j--);
            }
        }

        if (left < j) {
            quickSortFunc(arr, left, j);
        }
        if (i < right){
            quickSortFunc(arr, i, right);
        }

    }

    public static void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}