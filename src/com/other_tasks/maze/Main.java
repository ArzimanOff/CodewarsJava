package com.other_tasks.maze;

import java.io.File;
import java.io.FileNotFoundException;
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
    static String formatErrStr = "Неверный формат файла, не достаточно данных";
    static Scanner scanner;
    static Scanner fileScanner;
    static Scanner sc = new Scanner(System.in);


    static {
        try {
            fileScanner = new Scanner(new File("src/mazeField.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Введите 0, чтобы произвести чтение из файла");
        System.out.println("Введите 1, чтобы произвести чтение из консоли");
        System.out.println("Введите 2, чтобы рандомно сгенерировать матрицу лабиринта:");
        int ans = sc.nextInt();
        int N = 0;
        int M = 0;
        int[][] arrVertical;
        int[][] arrHorizontal;
        if (ans == 2){
            scanner = sc;
            System.out.println("Введите размерность лабиринта который нудно сгенерировать: ");
            if (scanner.hasNextInt()){
                N = scanner.nextInt();
            } else {
                System.err.println(formatErrStr);
                return;
            }
            if (scanner.hasNextInt()){
                M = scanner.nextInt();
            } else {
                System.err.println(formatErrStr);
            }
            arrVertical = new int[N][M];
            arrHorizontal = new int[N][M];
            generateVerticalMatrix(N, M, arrVertical);
            generateHorizontalMatrix(N, M, arrHorizontal);
        } else {
            if (ans == 0){
                scanner = fileScanner;
            } else if (ans == 1) {
                scanner = sc;
                System.out.println("Введите данные: ");
            } else {
                System.out.println("Неверный ввод!");
            }

            if (scanner.hasNextInt()){
                N = scanner.nextInt();
            } else {
                System.err.println(formatErrStr);
                return;
            }
            if (scanner.hasNextInt()){
                M = scanner.nextInt();
            } else {
                System.err.println(formatErrStr);
            }

            System.out.println(N);
            System.out.println(M);
            arrVertical = new int[N][M];
            arrHorizontal = new int[N][M];
            readData(N, M, arrVertical, arrHorizontal);
        }

        Maze maze = new Maze(N, M, arrVertical, arrHorizontal);
    }

    private static void generateVerticalMatrix(int N, int M, int[][] Arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == M - 1){
                    Arr[i][j] = 1;
                } else {
                    Arr[i][j] = (int) (Math.random() * 2);
                }
            }
        }
    }
    private static void generateHorizontalMatrix(int N, int M, int[][] Arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == N - 1){
                    Arr[i][j] = 1;
                } else {
                    Arr[i][j] = (int) (Math.random() * 2);
                }
            }
        }
    }



    private static void readData(int N, int M, int[][] arrVertical, int[][] arrHorizontal ) {
        readMatrix(N, M, arrVertical);
        readMatrix(N, M, arrHorizontal);
    }

    private static void readMatrix(int N, int M, int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (scanner.hasNextInt()){
                    arr[i][j] = scanner.nextInt();
                } else {
                    System.err.println("Неверный формат файла, не достаточно данных");
                }
            }
        }
    }
}