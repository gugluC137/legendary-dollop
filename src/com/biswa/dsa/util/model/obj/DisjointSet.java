package com.biswa.dsa.util.model.obj;

public class DisjointSet {
    private final int[] parent;
    private final int[] size;
    private final int[] rank;

    public void setParent(int node, int val) {
        this.parent[node] = val;
    }

    public void setSize(int node, int val) {
        this.size[node] = val;
    }

    public void setRank(int node, int val) {
        this.rank[node] = val;
    }

    public DisjointSet(int cap) {
        this.parent = new int[cap+1];
        this.size = new int[cap+1];
        this.rank = new int[cap+1];
        for (int i = 0; i <= cap; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
            this.rank[i] = 0;
        }
    }

    //TC: O(4C) where C is a derived constant. We can assume this to be O(1)
    //When findSet is called for a node first time, path compression is done.
    //subsequent calls have TC of constant time.
    public int findSet(int n) {
        if (this.parent[n] == n) {
            return n;
        }

        return this.parent[n] = findSet(parent[n]);
    }

    //TC: O(4C) where C is a derived constant. We can assume this to be O(1)
    public void unionByRank(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        //if ultimate parents are same, no union is required
        if (px == py) return;

        if (this.rank[px] < this.rank[py]) {
            setParent(px, py);
        } else {
            setParent(py, px);
        }

        if (this.rank[px] == this.rank[py]) {
            setRank(px, this.rank[px] + 1);
        }
    }

    //TC: O(4C) where C is a derived constant. We can assume this to be O(1)
    public void unionBySize(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        //if ultimate parents are same, no union is required
        if (px == py) return;

        if (this.size[px] < this.size[py]) {
            setParent(px, py);
            int newSize = this.size[px] + this.size[py];
            setSize(py, newSize);
        } else {
            setParent(py, px);
            int newSize = this.size[px] + this.size[py];
            setSize(px, newSize);
        }
    }
}
