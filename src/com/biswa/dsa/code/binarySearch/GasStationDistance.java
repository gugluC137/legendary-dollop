package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GasStationDistance {

    //TC: O(NlogN + KlogN)
    //SC: O(N-1)
    public double minimiseMaxDistance(int[] arr, int k) {
        var n = arr.length;
        var q = new PriorityQueue<Pair>();
        //in-case you declare Pair as static inner class (won't be able to implement Comparable)
        //var q = new PriorityQueue<Pair>((a, b) -> Double.compare(b.dist, a.dist));

        // insert the first n-1 elements into pq
        // with respective distance values:
        for (var i = 0; i < n-1; i++) {
            q.offer(new Pair(arr[i+1] - arr[i], i));
        }

        var howMany = new int[n-1];
        Arrays.fill(howMany, 0);

        // Pick and place k gas stations:
        for (int i = 0; i < k; i++) {
            // Find the maximum section
            // and insert the gas station:
            var p = q.poll();
            var secIdx = p.idx;

            // insert the current gas station:
            howMany[secIdx]++;

            double diff = arr[secIdx+1] - arr[secIdx];
            var newDiff = diff / (howMany[secIdx]+1);
            q.offer(new Pair(newDiff, secIdx));
        }

        return q.peek().dist;
    }

    public static void main(String[] args) {
        var arr = new int[]{1,13,17,23};
        var arr2 = new int[]{1,2,3,4,5};
        System.out.println(new GasStationDistance().minimiseMaxDistance(arr, 5));
        System.out.println(new GasStationDistance().minimiseMaxDistance(arr2, 4));
    }
}

class Pair implements Comparable<Pair> {
    double dist;
    int idx;

    Pair(double d, int i) {
        this.dist = d;
        this.idx = i;
    }

    @Override
    public int compareTo(Pair obj) {
        return Double.compare(obj.dist, this.dist);
    }
}
