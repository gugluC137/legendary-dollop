package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.*;

public class NumberOfDistinctIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<List<String>> st = new HashSet<>();
        boolean[][] vis = new boolean[rows][cols];
        for(boolean[] v : vis) {
            Arrays.fill(v, false);
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    st.add(bfs(grid, vis, rows, cols, new Pair(i, j)));
                }
            }
        }

        return st.size();
    }

    private String toStr(int x, int y) {
        return x + "," + y;
    }

    private List<String> bfs(char[][] grid, boolean[][] vis, int rows, int cols, Pair c) {
        int row0 = c.x;
        int col0 = c.y;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        q.offer(c);
        list.add(toStr(0, 0));
        vis[c.x][c.y] = true;

        int[] delx = {-1, 0, 1, 0};
        int[] dely = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur.x + delx[i];
                int y = cur.y + dely[i];

                if (x < 0 || y < 0 || x >= rows || y >= cols) {
                    continue;
                }

                if (!vis[x][y] && grid[x][y] == '1') {
                    vis[x][y] = true;
                    q.offer(new Pair(x, y));
                    list.add(toStr(x-row0, y-col0));
                }
            }
        }
        return list;
    }
}


