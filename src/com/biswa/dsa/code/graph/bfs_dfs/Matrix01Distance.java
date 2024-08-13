package com.biswa.dsa.code.graph.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01Distance {
    public int[][] updateMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] ans = new int[R][C];
        boolean[][] vis = new boolean[R][C];
        Queue<Elem> q = new LinkedList<>();

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Elem(i, j, 0));
                    vis[i][j] = true;
                } else {
                    vis[i][j] = false;
                }
            }
        }

        int[] delx = {-1, 0, 1, 0};
        int[] dely = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Elem e = q.poll();
            ans[e.x][e.y] = e.dist;

            for (int i = 0; i < 4; i++) {
                int x = e.x + delx[i];
                int y = e.y + dely[i];

                if (x < 0 || x >= R || y < 0 || y >= C || vis[x][y]) {
                    continue;
                }

                q.offer(new Elem(x, y, e.dist+1));
                vis[x][y] = true;
            }
        }

        return ans;
    }
}

class Elem {
    int x;
    int y;
    int dist;

    Elem(int _x, int _y, int _dist) {
        this.x = _x;
        this.y = _y;
        this.dist = _dist;
    }
}
