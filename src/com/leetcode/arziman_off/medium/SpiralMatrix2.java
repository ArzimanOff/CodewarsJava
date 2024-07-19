package com.leetcode.arziman_off.medium;

public class SpiralMatrix2 {
    public static void main(String[] args) throws InterruptedException {
        int[][] ans = generateMatrix(12);
        printMatrix(ans);
    }
    public static int[][] generateMatrix(int n) throws InterruptedException {
        int[][] res = new int[n][n];
        int dx = 1, dy = 0;
        int x = 0, y = 0;
        int temp = 0;

        for (int i = 0; i < n*n; i++) {
            res[y][x] = i+1;
            if ( !((x+dx)>=0 && (x+dx)<n) || !((y+dy)>=0 && (y+dy)<n) || res[y+dy][x+dx] != 0){
                temp = dx;
                dx = -dy;
                dy = temp;
            }
            x += dx;
            y += dy;
        }
        
        return res;
    }

    public static void printMatrix(int[][] arr) {
        int maxNum =arr.length * arr.length;
        int width = String.valueOf(maxNum).length();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%" + width + "d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
