package com.other_tasks;

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


public class Maze {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arrVertical = new int[N][M];
        int[][] arrHorizontal = new int[N][M];
        readData(N, M, arrVertical, arrHorizontal);
        printMaze(N, M, arrVertical, arrHorizontal);
    }

    private static void printMaze(int N, int M, int[][] A, int[][] B) {
        System.out.print("#####".repeat(2));
        System.out.print("###".repeat(M-2));
        System.out.println();

        for (int i = 0; i < N*2; i++) {
            System.out.print("#");
            for (int j = 0; j < M; j++) {
                if (i%2 == 0){
                    if(A[i/2][j] == 1){
                        System.out.print("   #");
                    } else {
                        System.out.print("    ");
                    }
                } else {
                    if (B[i/2][j] == 1){
                        System.out.print("####");
                    } else {
                        if (j == M-1){
                            System.out.print("   #");
                        } else {
                            System.out.print("    ");
                        }
                    }
                }
            }
            System.out.println();
        }
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
