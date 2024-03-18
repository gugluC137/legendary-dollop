package com.biswa.dsa.code.daily;

import java.util.*;

public class MinArrowShots {
    public int findMinArrowShots(int[][] points) {
        //        Arrays.sort(points, (a1, a2) -> {
        //          return a1[1] - a2[1];
        //        });
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        ArrayDeque<int[]> st = new ArrayDeque<>();

        for (int[] a : points) {
            if (st.isEmpty()) {
                st.push(a);
                continue;
            }

            int[] prev = st.peek();
            if (prev[1] >= a[0]) {
                st.pop();
                st.push(new int[]{Math.max(prev[0], a[0]), prev[1]});
            } else {
                st.push(a);
            }
        }

        return st.size();

    }

    public int findMinArrowShotsI(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int end = points[0][1];
        int arrows = 1;

        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
