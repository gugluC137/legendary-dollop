package com.biswa.dsa.code.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleDG {
    public boolean isCyclicDirectedGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                boolean[] pathVis = new boolean[v];
                Arrays.fill(pathVis, false);
                if (helperDfs(i, adj, vis, pathVis)) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean helperDfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int a : adj.get(node)) {
            //in undirected graph if the node in path is already visited we could confirm a cycle
            //in directed graph cycle can be confirmed if it has been visited and is in the path of the current dfs traversal
            if (vis[a]) {
                if (pathVis[a]) return true;
            } else {
                if (helperDfs(a, adj, vis, pathVis)) return true;
            }
        }

        pathVis[node] = false;
        return false;
    }
}
