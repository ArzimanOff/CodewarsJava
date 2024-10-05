package com.other_tasks.yandex_kotlin_coderun;

public class Test {
    public static void main(String[] args) {
        var rows = 1;
        var cols = 1;
        var map2 = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                int x1 = i + 1;
                int y1 = j + 1;

                int x2 = rows - i;
                int y2 = cols - j;

                map2[i][j] = x1 * y1 * x2 * y2;
            }
        }
        for (int i = 0; i < map2.length; i++){
            for (int j = 0; j < map2[0].length; j++){
                System.out.print(map2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
