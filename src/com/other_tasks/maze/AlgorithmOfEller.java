package com.other_tasks.maze;

public class AlgorithmOfEller {
    int N;
    int M;
    int[][] arrVertical;
    int[][] arrHorizontal;
    int[][] mainArr;
    int[][] mainBigArr;
    int[][] cellsIdArr;
    public AlgorithmOfEller(int n, int m) {
        this.N = n;
        this.M = m;
        this.arrVertical = new int[N][M];
        this.arrHorizontal = new int[N][M];
        this.mainArr = new int[N][M];
        this.cellsIdArr = new int[N][M];
        this.mainBigArr = new int[2*N + 1][2*M + 1];
        defaultFilling(mainBigArr, 1);
        defaultFilling(arrVertical, 1);
        defaultFilling(arrHorizontal, 1);
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

    public static void defaultFilling(int[][] Arr, int c){
        int rows = Arr.length;
        int cols = Arr[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                Arr[i][j] = c;
            }
        }
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int[][] getArrVertical() {
        return arrVertical;
    }

    public void setArrVertical(int[][] arrVertical) {
        this.arrVertical = arrVertical;
    }

    public int[][] getArrHorizontal() {
        return arrHorizontal;
    }

    public void setArrHorizontal(int[][] arrHorizontal) {
        this.arrHorizontal = arrHorizontal;
    }

    public int[][] getMainArr() {
        return mainArr;
    }

    public void setMainArr(int[][] mainArr) {
        this.mainArr = mainArr;
    }

    public int[][] getMainBigArr() {
        return mainBigArr;
    }

    public void setMainBigArr(int[][] mainBigArr) {
        this.mainBigArr = mainBigArr;
    }

    public int[][] getCellsIdArr() {
        return cellsIdArr;
    }

    public void setCellsIdArr(int[][] cellsIdArr) {
        this.cellsIdArr = cellsIdArr;
    }
}
