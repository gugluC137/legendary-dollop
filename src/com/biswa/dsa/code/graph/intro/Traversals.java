package com.biswa.dsa.code.graph.intro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Traversals {

    //TC for undirected graph: O(V) + O(2 x no of edges) [2nd part is of summation of degrees]
    //TC for directed graph: O(V) + O(no of edges)
    //SC: O(V) [for the queue]
    public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>(V);

        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int n : adj.get(node)) {
                if (!vis[n]) {
                    q.offer(n);
                    vis[n] = true;
                }
            }
        }

        return ans;
    }


    //TC for undirected graph: O(V) + O(2 x no of edges) [2nd part is of summation of degrees]
    //TC for directed graph: O(V) + O(no of edges)
    //SC: O(V) [for the recursion stack ]
    public ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>(V);
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        dfs(0, vis, adj, ans);
        return ans;
    }

    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);

        for (int n : adj.get(node)) {
            if (!vis[n]) {
                dfs(n, vis, adj, ans);
            }
        }
    }
}
