package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        for(boolean[] v : vis) {
            Arrays.fill(v, false);
        }

        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    bfs(grid, vis, rows, cols, new Pair(i, j));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] grid, boolean[][] vis, int rows, int cols, Pair c) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(c);

        vis[c.x][c.y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int delx = -1; delx <= 1; delx++) {
                for (int dely = -1; dely <= 1; dely++) {
                    int x = cur.x + delx;
                    int y = cur.y + dely;

                    if (x < 0 || y < 0 || x >= rows || y >= cols) {
                        continue;
                    }

                    if (!vis[x][y] && grid[x][y] == '1') {
                        vis[x][y] = true;
                        q.offer(new Pair(x, y));
                    }
                }
            }
        }
    }
}