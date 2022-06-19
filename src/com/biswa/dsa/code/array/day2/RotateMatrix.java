package com.biswa.dsa.code.array.day2;

import java.util.Arrays;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //get the transpose of the matrix
        transposeMatrix(matrix, n);
        System.out.println(Arrays.deepToString(matrix));

        //reverse each row
        reverseRows(matrix, n);
        System.out.println(Arrays.deepToString(matrix));
    }

    private void transposeMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }

    private void reverseRows(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix obj = new RotateMatrix();
        obj.rotate(arr);
//        System.out.println("Rotated Image");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
