package com.biswa.dsa.code.random;

import com.biswa.dsa.util.CustomReader;
import java.io.IOException;

public class PrintMatrix {

    public void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] input(int rows, int columns) throws IOException {
        int[][] m = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.out.println("enter elements of row " + (i+1) + " separated by spaces");
            for (int j = 0; j < columns; j++) {
                m[i][j] = CustomReader.nextInt();
            }
        }
        return m;
    }

    public static void main(String[] args) throws IOException {
        PrintMatrix obj = new PrintMatrix();
        CustomReader.init();

        int noOfRows = CustomReader.nextInt("Enter number of Rows:");
        int noOfColumns = CustomReader.nextInt("Enter number of Columns:");

        int[][] matrix = obj.input(noOfRows, noOfColumns);

        obj.print(matrix);

        CustomReader.close();
    }

}
