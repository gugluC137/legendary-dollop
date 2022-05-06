package com.biswa.dsa.code.array;

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

}
