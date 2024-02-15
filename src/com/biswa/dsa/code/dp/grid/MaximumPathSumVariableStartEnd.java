package com.biswa.dsa.code.dp.grid;

//Max variant: https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998
//Min variant: https://leetcode.com/problems/minimum-falling-path-sum/
public class MaximumPathSumVariableStartEnd {

    //TC: exponential + O(col)
    //SC: O(col)
    public int solWithRecursion(int i, int j, int[][] matrix) {
        if (i == 0) return matrix[i][j];

        int ld = Integer.MIN_VALUE, up = Integer.MIN_VALUE, rd = Integer.MIN_VALUE;

        up = solWithRecursion(i-1, j, matrix);
        if (j != 0) ld = solWithRecursion(i-1, j-1, matrix);
        if (j != matrix[i].length - 1) rd = solWithRecursion(i-1, j+1, matrix);

        return matrix[i][j] + Math.max(rd, Math.max(up, ld));
    }

    //TC: O(row*col) + O(col)
    //SC: O(col) + O(row*col)
    public int solWithMemoization(int i, int j, int[][] matrix, int[][] dp) {
        if (i == 0) return matrix[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int ld = Integer.MIN_VALUE, up = Integer.MIN_VALUE, rd = Integer.MIN_VALUE;

        up = solWithMemoization(i-1, j, matrix, dp);
        if (j != 0) ld = solWithMemoization(i-1, j-1, matrix, dp);
        if (j != matrix[i].length - 1) rd = solWithMemoization(i-1, j+1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.max(rd, Math.max(up, ld));
    }

    //TC: O(row*col) + O(col)
    //SC: O(row*col)
    public int solWithTabulation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ld = Integer.MIN_VALUE, up = Integer.MIN_VALUE, rd = Integer.MIN_VALUE;

                up = dp[i-1][j];
                if (j != 0) ld = dp[i-1][j-1];
                if (j != matrix[i].length - 1) rd = dp[i-1][j+1];

                dp[i][j] = matrix[i][j] + Math.max(rd, Math.max(up, ld));
            }
        }

        int maxPathSum = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            if (maxPathSum < dp[row-1][i]) maxPathSum = dp[row-1][i];
        }

        return maxPathSum;
    }

    //TC: O(row*col) + O(col)
    //SC: O(col)
    public int solWithSpaceOptimisation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] prev = new int[col];

        for (int i = 0; i < col; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            int[] cur = new int[col];
            for (int j = 0; j < col; j++) {
                int up = Integer.MIN_VALUE, ld = Integer.MIN_VALUE, rd = Integer.MIN_VALUE;

                up = prev[j];
                if (j != 0) ld = prev[j-1];
                if (j != col-1) rd = prev[j+1];

                cur[j] = matrix[i][j] + Math.max(rd, Math.max(up, ld));
            }
            prev = cur;
        }

        int maxPathSum = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            if (maxPathSum < prev[i]) maxPathSum = prev[i];
        }

        return maxPathSum;
    }

    //TC: O(row*col) + O(col)
    //SC: O(col)
    public int MinVariant(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] prev = new int[col];

        for (int i = 0; i < col; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            int[] cur = new int[col];
            for (int j = 0; j < col; j++) {
                int up = Integer.MAX_VALUE, ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;

                up = prev[j];
                if (j != 0) ld = prev[j-1];
                if (j != col-1) rd = prev[j+1];

                cur[j] = matrix[i][j] + Math.min(rd, Math.min(up, ld));
            }
            prev = cur;
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (minPathSum > prev[i]) minPathSum = prev[i];
        }

        return minPathSum;
    }

    public static void main(String[] args) {

    }
}
