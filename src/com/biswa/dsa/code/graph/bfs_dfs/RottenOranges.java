package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.ArrayDeque;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        int time = 0;
        int[][] state = new int[rows][cols];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (grid[i][j]) {
                    case 1: freshOranges++; break;
                    case 2: q.offer(new Pair(i, j)); break;
                    default:
                }
                state[i][j] = grid[i][j];
            }
        }

        while (!q.isEmpty()) {
            int curSize = q.size();

            for (int i = 0; i < curSize; i++) {
                Pair cur = q.poll();

                freshOranges -= rotNeighbours(cur.x, cur.y, rows, cols, state, q);
            }

            if (!q.isEmpty()) {
                time++;
            }
        }

        return freshOranges == 0 ? time : -1;
    }

    public int rotNeighbours(int x, int y, int rows, int cols, int[][] state, ArrayDeque<Pair> q) {
        int cnt = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int r = x + drow[i];
            int c = y + dcol[i];

            if (r >= 0 && c >= 0 && r < rows && c < cols && state[r][c] == 1) {
                state[r][c] = 2;
                q.offer(new Pair(r, c));
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new RottenOranges().orangesRotting(arr));
    }
}
