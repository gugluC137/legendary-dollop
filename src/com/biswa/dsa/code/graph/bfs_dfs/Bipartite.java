package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);

        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, graph, colors)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int color, int[][] graph, int[] colors) {
        colors[node] = color;

        for (int adj : graph[node]) {
            if (colors[adj] == -1) {
                if (!dfs(adj, 1 - color, graph, colors)) return false;
            } else {
                if (colors[adj] == color) return false;
            }
        }

        return true;
    }

    private boolean bfs(int node, int[][] graph, int[] colors) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(node, 0));
        colors[node] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int adj : graph[node]) {
                if (colors[adj] == -1) {
                    colors[adj] = 1-p.y;
                    q.offer(new Pair(adj, colors[adj]));
                } else {
                    if (colors[adj] == p.y) return false;
                }
            }
        }

        return true;
    }
}
