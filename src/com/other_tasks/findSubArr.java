package com.other_tasks;

import java.util.HashMap;

public class findSubArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 5};
        System.out.println(arr);
    }
    public int[] findSubArr(int[] arr){
        int len = arr.length; // 4
        int sum = 0;
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        arrMap.put(0, -1);
        // (1, 2, 1, 8)
        for (int i = 0; i < len; i++){
            sum += arr[i];
            int ost = sum % len;
            if(arrMap.containsKey(ost)){
                int start = arrMap.get(ost) + 1;
                int end = i;
                int[] result = new int[end - start + 1];
            }
            arrMap.put(ost, i);
        }
        return new int[0];
    }
}


