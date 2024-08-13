package com.biswa.dsa.code.graph.topo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                helper(i, adj, vis, st);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    public void helper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int a : adj.get(node)) {
            if (!vis[a]) {
                helper(a, adj, vis, st);
            }
        }

        st.push(node);
    }
}
