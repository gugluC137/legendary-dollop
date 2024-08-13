package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.*;


public class DetectCycleUG {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, adj, vis)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] vis) {
        vis[node] = true;
        for (int adj : adjList.get(node)) {
            if (!vis[adj]) {
                if (dfs(adj, node, adjList, vis)) return true;
            } else {
                if (adj != parent) return true;
            }
        }

        return false;
    }

    public boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (vis[i]) continue;

            ArrayDeque<Pair> q = new ArrayDeque<>();
            q.offer(new Pair(i, -1));

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int node = p.x;
                int parent = p.y;
                vis[node] = true;

                for (int a : adj.get(node)) {
                    if (!vis[a]) {
                        q.offer(new Pair(a, node));
                    } else {
                        if (a != parent) return true;
                    }
                }
            }
        }

        return false;
    }
}
