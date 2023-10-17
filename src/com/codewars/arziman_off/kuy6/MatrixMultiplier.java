/*
https://www.codewars.com/kata/573248f48e531896770001f9/train/java
*/

package com.codewars.arziman_off.kuy6;

public class MatrixMultiplier {
    public static double[][] getMatrixProduct(double[][] a, double[][] b) {
        if ( a == null || b == null){
            return null;
        }
        if (checkValidationForMultiplication(a, b)){
            int rowsA = a.length;
            int colsB = b[0].length;
            double[][] c = new double[rowsA][colsB];

            for (int i = 0; i < rowsA; i++){
                for (int j = 0; j < colsB; j++){
                    c[i][j] = 0;
                    for (int k = 0; k < a[0].length; k++){
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        } else {
            return null;
        }
    }

    /*
     функция возвращает true, если матрицы можно перемножить, и false, если нельзя
     */
    public static boolean checkValidationForMultiplication(double[][] a, double[][] b){
        if (checkMatrixValidation(a) && checkMatrixValidation(b)){
            int colsA = a[0].length;
            int rowsB = b.length;
            return colsA == rowsB;
        } else {
            return false;
        }
    }

    /*
     функция возвращает true, если матрица является прямоугольной, и false, если нет
     */
    public static boolean checkMatrixValidation(double[][] matrix){
        if (matrix == null){
            return false;
        }
        int rowsCnt = matrix.length;
        int colsCnt = matrix[0].length;
        for (int i = 0; i < rowsCnt; i++){
            if (matrix[i].length != colsCnt){
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(double[][] matrix){
        if (matrix == null){
            return;
        }
        int rowsCnt = matrix.length;
        int colsCnt = matrix[0].length;
        for (int i = 0; i < rowsCnt; i++){
            for (int j = 0; j < colsCnt; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] testMatrix3 = new double[][] { { 1, 2 }, { 3, 4 } };
        double[][] testMatrix4 = new double[][] { { 5, 6 }, { 7, 8 } };

        double[][] ansMatrix34 = getMatrixProduct(testMatrix3, testMatrix4);
        printMatrix(ansMatrix34);
    }
}
