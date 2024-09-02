package com.biswa.dsa.util.model.obj;

public class Pair implements Comparable<Pair> {
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

    public int compareTo(Pair p) {
        if (this.x == p.x) return this.y - p.y;
        return this.x - p.x;
    }

    @Override
    public String toString() {
        return x + ": " + y;
    }
}
