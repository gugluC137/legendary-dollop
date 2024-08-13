package com.biswa.dsa.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;


//TC: O(E*logV), E = total number of edges (worst case E = V^2), V = total number of nodes
//Ref: https://youtu.be/3dINsjyfooY?si=NYHjkAWWcZPPTAf9
//SC: O(2V)
public class Dijkstra {
    public int[] dijkstraSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        var set = new TreeSet<Pair>((e1, e2) -> {
            if (e1.x == e2.x) return e1.y - e2.y;
            else return e1.x - e2.x;
        });
        var dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        set.add(new Pair(0, S));
        dist[S] = 0;
        while (!set.isEmpty()) {
            int dis = set.first().x;
            int node = set.first().y;
            set.pollFirst();

            for (var nextAdj : adj.get(node)) {
                int adjNode = nextAdj.get(0);
                int edgeWeight = nextAdj.get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    set.remove(new Pair(dist[adjNode], adjNode));

                    dist[adjNode] = dis + edgeWeight;
                    set.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    public int[] dijkstraPQ(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        var pq = new PriorityQueue<Pair>();
        var dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Pair(0, S));
        dist[S] = 0;
        while (!pq.isEmpty()) {
            int edgeWeight = pq.peek().x;
            int adjNode = pq.peek().y;
            pq.poll();

            for (var nextAdj : adj.get(adjNode)) {
                int d = nextAdj.get(0);
                int n = nextAdj.get(1);

                if (edgeWeight + d < dist[n]) {
                    dist[n] = edgeWeight + d;
                    pq.offer(new Pair(dist[n], n));
                }
            }
        }

        return dist;
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Pair obj)) {
            return false;
        }
        return this.x == obj.x && this.y == obj.y;
    }

    public int hashCode() {
        return Integer.hashCode(this.x) * Integer.hashCode(this.y);
    }
}
