package com.biswa.dsa.code.random;

import java.util.Arrays;

public class LISMatrix {

    int[][] moves = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[][] dp = new int[R][C];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        int ans = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dp[i][j] == -1) {
                    ans = Math.max(ans, helperMemo(i, j, matrix, dp, R, C));
                } else {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public int helperMemo(int i, int j, int[][] matrix, int[][] dp, int R, int C) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int lis = 0;

        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];

            if (x < 0 || x >= R || y < 0 || y >= C || matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            lis = Math.max(lis, helperMemo(x, y, matrix, dp, R, C));
        }

        return dp[i][j] = lis+1;
    }
}
