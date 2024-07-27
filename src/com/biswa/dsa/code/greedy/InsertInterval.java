package com.biswa.dsa.code.greedy;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var ansList = new ArrayList<int[]>();
        var i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ansList.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ansList.add(newInterval);

        while (i < intervals.length) {
            ansList.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[ansList.size()][2];
        for (int j = 0; j < ansList.size(); j++) {
            ans[j] = ansList.get(j);
        }

        return ans;
    }
}
