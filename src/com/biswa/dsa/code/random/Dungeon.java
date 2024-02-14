package com.biswa.dsa.code.random;

import java.util.Arrays;

public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

//        int[][] dp = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//
//        int minResistance = calculateResistanceMemoization(dungeon, rows, cols, 0, 0, dp);

        int minResistance = calculateResistanceTabulation(dungeon, rows, cols);

        return Math.abs(minResistance-1);
    }

    public int calculateResistanceRecursive(final int[][] dungeon, final int rows, final int cols,
                                            int r, int c) {
        //base condition
        if (r == rows-1 && c == cols-1) {
            return dungeon[r][c];
        }

        //process
        int resR = Integer.MIN_VALUE, resD = Integer.MIN_VALUE;

        if (c+1 < cols) {
            resR = calculateResistanceRecursive(dungeon, rows, cols, r, c+1);
        }

        if (r+1 < rows) {
            resD = calculateResistanceRecursive(dungeon, rows, cols, r+1, c);
        }

        return Math.min(0, dungeon[r][c] + Math.max(resR, resD));
    }

    public int calculateResistanceMemoization(final int[][] dungeon, final int rows, final int cols,
                                              int r, int c, final int[][] dp) {
        //base condition
        if (r == rows-1 && c == cols-1) {
            return Math.min(0, dungeon[r][c]);
        }

        if (dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        }

        //process
        int resR = Integer.MIN_VALUE, resD = Integer.MIN_VALUE;

        if (c+1 < cols) {
            resR = calculateResistanceMemoization(dungeon, rows, cols, r, c+1, dp);
        }

        if (r+1 < rows) {
            resD = calculateResistanceMemoization(dungeon, rows, cols, r+1, c, dp);
        }

        return dp[r][c] = Math.min(0, dungeon[r][c] + Math.max(resR, resD));
    }

    public int calculateResistanceTabulation(final int[][] dungeon, final int rows, final int cols) {

        int[][] dp = new int[rows][cols];

        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >= 0; j--) {
                //base condition
                if (i == rows-1 && j == cols-1) {
                    dp[i][j] = Math.min(0, dungeon[i][j]);
                    continue;
                }

                int resR = (j+1 < cols) ? dp[i][j+1] : Integer.MIN_VALUE;
                int resD = (i+1 < rows) ? dp[i+1][j] : Integer.MIN_VALUE;

                dp[i][j] = Math.min(0, dungeon[i][j] + Math.max(resR, resD));
            }
        }

        return dp[0][0];
    }

    public int calculateResistanceSpaceOptimised(final int[][] dungeon, final int rows, final int cols) {

        int[] next = new int[cols];

        for (int i = rows-1; i >= 0; i--) {
            int[] cur = new int[cols];
            for (int j = cols-1; j >= 0; j--) {
                //base condition
                if (i == rows-1 && j == cols-1) {
                    cur[j] = Math.min(0, dungeon[i][j]);
                    continue;
                }

                int resR = (j+1 < cols) ? cur[j+1] : Integer.MIN_VALUE;
                int resD = (i+1 < rows) ? next[j] : Integer.MIN_VALUE;

                cur[j] = Math.min(0, dungeon[i][j] + Math.max(resR, resD));
            }
            next = cur;
        }

        return next[0];
    }

}
