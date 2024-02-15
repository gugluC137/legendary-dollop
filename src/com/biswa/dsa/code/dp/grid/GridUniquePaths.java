package com.biswa.dsa.code.dp.grid;

import java.util.Arrays;

public class GridUniquePaths {

    //TC: O(2^(row*col))
    //SC: O(path length), path length = row-1 + col-1
    public int solWithRecursion(int i, int j, int row, int col) {

        if (i == 0 && j == 0) return 1;

        int left = 0, up = 0;
        if (i != 0) up = solWithRecursion(i-1, j, row, col);
        if (j != 0) left = solWithRecursion(i, j-1, row, col);

        return up + left;
    }

    //TC: O(row*col)
    //SC: O(row*col) + O(path length)
    public int solWithMemoization(int i, int j, int row, int col, int[][] dp) {

        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int left = 0, up = 0;
        if (i != 0) up = solWithRecursion(i-1, j, row, col);
        if (j != 0) left = solWithRecursion(i, j-1, row, col);

        return dp[i][j] = up + left;
    }

    //TC: O(row*col)
    //SC: O(row*col)
    public int solWithTabulation(int row, int col) {

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }

    //TC: O(row*col)
    //SC: O(col)
    public int solWithSpaceOptimisation(int row, int col) {

        int[] prev = new int[col];
        Arrays.fill(prev, 1);

        for (int i = 1; i < row; i++) {
            int[] cur = new int [col];
            cur[0] = 1;
            for (int j = 1; j < col; j++) {
                cur[j] = prev[j] + cur[j-1];
            }
            prev = cur;
        }

        return prev[col-1];
    }

    public static void main(String[] args) {
    }
}
