package com.biswa.dsa.temp;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        var m = new TreeMap<Integer, Integer>();
        m.put(1,1);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {

        }
//        int[] a = {1,2,3,4};
//        System.out.println(Arrays.stream(a).sum());
//        System.out.println(Arrays.stream(a).max().getAsInt());
    }

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
