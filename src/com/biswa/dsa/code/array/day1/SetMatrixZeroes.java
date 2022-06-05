package com.biswa.dsa.code.array.day1;

import java.util.Arrays;

public class SetMatrixZeroes {

  public void solve(int[][] matrix) {

      int rowLength = matrix.length;
      int columnLength = matrix[0].length;

      int[] row = new int[rowLength];
      int[] column = new int[columnLength];

      Arrays.fill(row, 1);
      Arrays.fill(column, 1);

      for (int r = 0; r < rowLength; r++) {
        for (int c = 0; c < columnLength; c++) {
          if (matrix[r][c] == 0) {
            row[r] = 0;
            column[c] = 0;
          }
        }
      }

      for (int r = 0; r < rowLength; r++) {
        for (int c = 0; c < columnLength; c++) {
          if (row[r] == 0 || column[c] == 0) {
            matrix[r][c] = 0;
          }
        }
      }

  }

  public void solveOptimised(int[][] matrix) {
    int rowLength = matrix.length;
    int columnLength = matrix[0].length;
    int col0 = 1;

    for (int i = 0; i < rowLength; i++) {
      if (matrix[i][0] == 0) col0 = 0;
      for (int j = 1; j < columnLength; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }

    for (int i = rowLength-1; i >= 0; i--) {
      for (int j = columnLength-1; j > 0; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (col0 == 0) matrix[i][0] = 0;
    }

  }

}
