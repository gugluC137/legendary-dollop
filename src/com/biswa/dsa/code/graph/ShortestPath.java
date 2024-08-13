package com.biswa.dsa.code.graph;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPath {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        var adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }

        var dist = new int[n+1];
        var parent = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, 0);

        return null;
    }
}
