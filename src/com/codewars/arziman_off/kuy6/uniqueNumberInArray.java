package com.codewars.arziman_off.kuy6;

import java.util.HashMap;
import java.util.Map;
public class uniqueNumberInArray {
    public static double findUniq(double[] arr) {
        Map<Double, Integer> uniqueMap = new HashMap<>();

        for (double num : arr) {
            uniqueMap.put(num, uniqueMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Double, Integer> entry : uniqueMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("В массиве нет уникальных чисел!");
    }

    public static void main(String[] args) {
        double[] arr = new double[1000000];
        for (int i = 1; i < 1000000; i++) {
            if (i == 734534){
                arr[i] = 55556;
            } else {
                arr[i] = 55555;
            }
        }
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // Output: 2.0
        System.out.println(findUniq(arr));
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));   // Output: 0.55
    }
}

