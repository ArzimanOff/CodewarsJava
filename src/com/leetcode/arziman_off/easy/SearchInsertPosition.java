package com.leetcode.arziman_off.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(arr, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left]) return 0;
        if (target > nums[right]) return right + 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
}