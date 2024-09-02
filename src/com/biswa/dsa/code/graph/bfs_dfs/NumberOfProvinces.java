package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.DisjointSet;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    public int findNumOfProvinces(int[][] roads, int n) {
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                markCitiesInProvince(roads, n, i, vis);
                cnt++;
            }
        }

        return cnt;
    }

    public void markCitiesInProvince(int[][] roads, int n, int city, boolean[] vis) {
        vis[city] = true;

        for (int i = 0; i < n; i++) {
            if (!vis[i] && roads[city][i] == 1) {
                markCitiesInProvince(roads, n, i, vis);
            }
        }
    }

    public int sol(int[][] roads, int n) {
        var ds = new DisjointSet(n);
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (roads[i][j] == 1 && ds.findSet(i) != ds.findSet(j)) {
                    ds.unionBySize(i, j);
                }
            }
        }

        var cnt = 0;
        for (var i = 0; i < n; i++) {
            if (ds.findSet(i) == i) cnt++;
        }

        return cnt;
    }
}
