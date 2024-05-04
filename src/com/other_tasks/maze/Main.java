package com.other_tasks.maze;

import java.util.Scanner;


//Алгоритм отрисовки лабиринта по входным данным из stdin
//Формат входных данных:
//Лабиринт может храниться в файле в виде количества строк и столбцов,
//а также двух матриц, содержащих положение вертикальных и горизонтальных стен соответственно.
//В первой матрице отображается наличие стены справа от каждой ячейки, а во второй - снизу.
//        Пример подобного файла:
//        4 4
//        0 0 0 1
//        1 0 1 1
//        0 1 0 1
//        0 0 0 1
//
//        1 0 1 0
//        0 0 1 0
//        1 1 0 1
//        1 1 1 1

// эталонная квадратная ячейка лабиринта:
//System.out.println("#".repeat(11));
//for (int i = 0; i < 3; i++) {
//    System.out.print("#");
//    System.out.print(" ".repeat(9));
//    System.out.print("#");
//    System.out.println();
//}
//System.out.println("#".repeat(11));
//вывод:
//###########
//#         #
//#         #
//#         #
//###########

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arrVertical = new int[N][M];
        int[][] arrHorizontal = new int[N][M];
        readData(N, M, arrVertical, arrHorizontal);
        Maze maze = new Maze(N, M, arrVertical, arrHorizontal);
    }



    private static void readData(int N, int M, int[][] arrVertical, int[][] arrHorizontal ) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrVertical[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrHorizontal[i][j] = scanner.nextInt();
            }
        }
    }
}