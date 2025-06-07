package com.biswa.dsa.code.graph.intro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Traversals {

    //TC for undirected graph: O(V) + O(2 x no of edges) [2nd part is of summation of degrees]
    //TC for directed graph: O(V) + O(no of edges)
    //SC: O(2V) [for the queue and visited array]
    public List<Integer> bfs(int V, List<List<Integer>> adj) {
        var ans = new ArrayList<Integer>(V);

        var visited = new boolean[V];
        Arrays.fill(visited, false);

        var q = new ArrayDeque<Integer>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            var node = q.poll();

            //this represents any process that needs to be done on each node
            ans.add(node);

            for (var n : adj.get(node)) {
                if (!visited[n]) {
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }

        return ans;
    }


    //TC for undirected graph: O(V) + O(2 x no of edges) [2nd part is of summation of degrees]
    //TC for directed graph: O(V) + O(no of edges)
    //SC: O(V) [for the recursion stack, visited array]
    public List<Integer> dfs_recursive(int V, List<List<Integer>> adj) {
        var ans = new ArrayList<Integer>(V);
        var visited = new boolean[V];
        Arrays.fill(visited, false);

        dfs(0, visited, adj, ans);

        return ans;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> ans) {
        visited[node] = true;

        //this represents any process that needs to be done on each node
        ans.add(node);

        for (var n : adj.get(node)) {
            if (!visited[n]) {
                dfs(n, visited, adj, ans);
            }
        }
    }

    public List<Integer> dfs_iterative(int V, List<List<Integer>> adj) {
        var ans = new ArrayList<Integer>(V);

        var visited = new boolean[V];
        Arrays.fill(visited, false);

        var stack = new ArrayDeque<Integer>();
        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            ans.add(node);

            for (var n: adj.get(node)) {
                if (!visited[n]) {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }

        return ans;
    }
}
