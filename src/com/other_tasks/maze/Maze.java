package com.other_tasks.maze;

public class Maze {
    int N;
    int M;
    int[][] arrVertical;
    int[][] arrHorizontal;
    static int[][] mainArr;
    static int[][] A;
    public Maze(int n, int m, int[][] arrVertical, int[][] arrHorizontal) {
        N = n;
        M = m;
        this.arrVertical = arrVertical;
        this.arrHorizontal = arrHorizontal;
        mainArr = new int[2*N + 1][2*M + 1];
        A = new int[5*N][11*M];
        defaultFilling(A, 0);
        defaultFilling(mainArr, 1);
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                x = 2*i + 1;
                y = 2*j + 1;
                mainArr[x][y] = 0;
                if (arrVertical[i][j] == 0) {
                    mainArr[x][y+1] = 0;
                }
                if (arrHorizontal[i][j] == 0){
                    mainArr[x+1][y] = 0;
                }

            }
        }
        printMatrix(mainArr);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                x = 2*i + 1;
                y = 2*j + 1;
                System.out.println(x + " " + y);
            }
        }
        x = 0;
        y = 0;
        int z = 0;
        int w = 0;
        System.out.println();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                x = 2*i + 1;
                y = 2*j + 1;
                z = 5*i + 2;
                w = 11*j + 5;
                if (mainArr[x][y] == 0) {
                    A[z][w] = 2;
                }
                normalizeTheCell(x, y, z, w);
            }
        }

        printMatrix(A);
        printField(A);
    }

    private void printField(int[][] Arr) {
        int rows = Arr.length;
        int cols = Arr[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (Arr[i][j] == 1){
                    System.out.print("#");
                } else if (Arr[i][j] == 2) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void defaultFilling(int[][] Arr, int c){
        int rows = Arr.length;
        int cols = Arr[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                Arr[i][j] = c;
            }
        }
    }

    public static void normalizeTheCell(int x, int y, int z, int w){
        // {x, y} - координаты центра ячейки в массиве А (массив для отрисовки)
        if (mainArr[x][y-1] == 1){
            // значит слева от ячейки есть стена
            int left = w - 5;
            int leftStart = z - 2;
            int leftEnd = z + 2;
            for (; leftStart <= leftEnd; leftStart++){
                A[leftStart][left] = 1;
            }
        }

        if (mainArr[x][y+1] == 1){
            // значит справа от ячейки есть стена
            int right = w + 5;
            int rightStart = z - 2;
            int rightEnd = z + 2;
            for (; rightStart <= rightEnd; rightStart++){
                A[rightStart][right] = 1;
            }
        }

        if (mainArr[x-1][y] == 1){
            // значит сверху от ячейки есть стена
            int up = z - 2;
            int upStart = w - 5;
            int upEnd = w + 5;
            for (; upStart <= upEnd; upStart++){
                A[up][upStart] = 1;
            }
        }

        if (mainArr[x+1][y] == 1){
            // значит снизу от ячейки есть стена
            int down = z + 2;
            int downStart = w - 5;
            int downEnd = w + 5;
            for (; downStart <= downEnd; downStart++){
                A[down][downStart] = 1;
            }
        }
    }


    public static void printMatrix(int[][] Arr){
        int rows = Arr.length;
        int cols = Arr[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                System.out.print(Arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
