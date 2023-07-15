package com.biswa.dsa.code.dp;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/minimum-path-sum_985349
public class MinimumSumPath {

    //TC: O(2^(row*col))
    //SC: O(path length)
    public int solWithRecursion(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) return grid[i][j];

        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

        if (i != 0) up = solWithRecursion(i-1, j, grid);
        if (j != 0) left = solWithRecursion(i, j-1, grid);

        return grid[i][j] + Math.min(up, left);
    }

    //TC: O(row*col)
    //SC: O(path length) + O(row*col)
    public int solWithMemoization(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

        if (i != 0) up = solWithMemoization(i-1, j, grid, dp);
        if (j != 0) left = solWithMemoization(i, j-1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }

    //TC: O(row*col)
    //SC: O(row*col)
    public int solWithTabulation(int row, int col, int[][] grid) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];

                int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if (i != 0) up = dp[i-1][j];
                if (j != 0) left = dp[i][j-1];

                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return dp[row-1][col-1];
    }

    //TC: O(row*col)
    //SC: O(col)
    public int solWithSpaceOptimised(int row, int col, int[][] grid) {
        int[] prev = new int[col];

        for (int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i != 0) up = prev[j];
                    if (j != 0) left = cur[j-1];

                    cur[j] = grid[i][j] + Math.min(up, left);
                }

            }
            prev = cur;
        }

        return prev[col-1];
    }

    public static void main(String[] args) {

    }
}
