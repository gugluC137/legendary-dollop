package com.biswa.dsa.code.contest.contest299;

public class CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        boolean flag;

        int n = grid.length;
        flag = check(grid, n);

        return flag;
    }

    private boolean check(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i+j == n-1) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }

        return true;
    }

}
