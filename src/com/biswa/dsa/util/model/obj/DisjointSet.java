package com.biswa.dsa.util.model.obj;

import java.util.Arrays;

public class DisjointSet {
    private final int[] parents;
    private final int[] rank;

    public void setParents(int n, int val) {
        this.parents[n] = val;
    }

    public void setRank(int n, int val) {
        this.rank[n] = val;
    }

    public DisjointSet(int cap) {
        this.parents = new int[cap];
        for (int i = 0; i < cap; i++) {
            this.parents[i] = i;
        }

        this.rank = new int[cap];
        Arrays.fill(this.rank, 0);
    }

    public int findSet(int n) {
        if (this.parents[n] == n) {
            return n;
        }

        return this.parents[n] = findSet(this.parents[n]);
    }

    public void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x != y) {
            if (this.rank[x] < this.rank[y]) {
                int temp = x;
                x = y;
                y = temp;
            }

            this.parents[y] = x;

            if (this.rank[x] == this.rank[y]) {
                this.rank[x]++;
            }
        }
    }
}
