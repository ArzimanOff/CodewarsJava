package com.leetcode.arziman_off.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummaryRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        List<String> answerList = summaryRanges(arr);
        System.out.println(answerList);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ansList = new ArrayList<>();
        int len = nums.length;
        if (len >= 2){
            int left = nums[0];
            int prevRight = left;
            int right;
            for (int i = 1; i < len; i++){
                right = nums[i];
                if (right - prevRight == 1){
                    prevRight = right;
                } else if (right - prevRight >= 2) {
                    if (left == prevRight){
                        ansList.add(String.valueOf(left));
                    } else {
                        ansList.add(left + "->" + prevRight);
                    }
                    left = right;
                    prevRight = left;
                }
                if (i == len-1){
                    if(left == prevRight){
                        ansList.add(String.valueOf(left));
                    } else {
                        ansList.add(left + "->" + prevRight);
                    }
                }
            }
        } else if (len == 1){
            ansList.add(String.valueOf(nums[0]));
        }
        return ansList;
    }
}
// 1 2 3 5 7 8
// 1->3
// 5
// 7->8