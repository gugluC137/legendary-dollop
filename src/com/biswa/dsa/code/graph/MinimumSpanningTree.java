package com.biswa.dsa.code.graph;

import com.biswa.dsa.util.model.obj.DisjointSet;

import java.util.*;

public class MinimumSpanningTree {
    //Prim's Algorithm
    public int spanningTreePrim(int V, int E, List<List<int[]>> adj) {
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(e -> e[0]));
        pq.offer(new int[]{0, 0, -1});

        var vis = new boolean[V];
        Arrays.fill(vis, false);

        var mstEdges = new ArrayList<int[]>();
        var sum = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[1];

            if (vis[node]) continue;

            vis[node] = true;
            if (edge[2] != -1) {
                sum += edge[0];
                mstEdges.add(edge);
            }

            for (var ad : adj.get(node)) {
                if (vis[ad[0]]) continue;
                pq.offer(new int[]{ad[1], ad[0], node});
            }
        }

        System.out.println(mstEdges);

        return sum;
    }

    //Kruskal's Algorithm
    public int spanningTreeKruskal(int V, int E, List<List<int[]>> adj) {
        //SC: O(E)
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(e -> e[0]));
        //O(V + E*logE)
        for (var i = 0; i < V; i++) {
            for (var ad : adj.get(i)) {
                pq.offer(new int[]{ad[1], ad[0], i});
            }
        }

        var mstEdges = new ArrayList<int[]>();
        var sum = 0;
        var ds = new DisjointSet(V);

        //O(E*4*alpha*2) : *2 is for find and union
        while (!pq.isEmpty()) {
            var edge = pq.poll();
            var u = edge[1];
            var v = edge[2];
            var w = edge[0];

            if (ds.findSet(u) != ds.findSet(v)) {
                sum += w;
                mstEdges.add(new int[]{w, u, v});
                ds.unionBySize(u, v);
            }
        }

        System.out.println(mstEdges);

        return sum;
    }
}
