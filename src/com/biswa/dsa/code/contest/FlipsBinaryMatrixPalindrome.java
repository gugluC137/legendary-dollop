package com.biswa.dsa.code.contest;

//https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/
public class FlipsBinaryMatrixPalindrome {
    public int minFlips(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int rowAns = 0;
        int colAns = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    if (grid[i][C-1-j] != 1) {
                        rowAns++;
                    }
                    if (grid[R-1-i][j] != 1) {
                        colAns++;
                    }
                }
            }
        }

        return Math.min(rowAns, colAns);
    }
}
