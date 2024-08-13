package com.biswa.dsa.code.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/time-taken-to-mark-all-nodes/description/
public class TimeTakenMarkNodes {
    public int[] timeTaken(int[][] edges) {
        int v = 0;
        for (int[] e : edges) {
            v = Math.max(v, Math.max(e[0], e[1]));
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] time = new int[v+1];
        for (int i = 0; i <= v; i++) {
            boolean[] vis = new boolean[v+1];
            Arrays.fill(vis, false);
            time[i] = dfs(i, 0, adj, vis, v);
        }

        return time;
    }

    public int dfs(int node, int time, List<List<Integer>> adj, boolean[] vis, int v) {
        vis[node] = true;
        int maxTime = time;
        for (int a : adj.get(node)) {
            if (!vis[a]) {
                int nextTime = a%2 == 0 ? time+2 : time+1;
                maxTime = Math.max(maxTime, dfs(a, nextTime, adj, vis, v));
            }
        }

        return maxTime;
    }
}
