package com.biswa.dsa.code.array.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] solution(int[][] intervals) {
        //sort the intervals in asc order
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        System.out.println(Arrays.deepToString(intervals));

        List<List<Integer>> result = new ArrayList<>();
        int s, e;
        for (int[] interval : intervals) {
            s = interval[0]; e = interval[1];

            if (!result.isEmpty() && result.get(result.size()-1).get(1) >= s) {
                int end = result.get(result.size()-1).get(1);
                result.get(result.size()-1).set(1, Math.max(end, e));
            } else {
                result.add(Arrays.asList(s, e));
            }
        }

        int[][] ans = new int[result.size()][2];
        int i = 0;
        for (List<Integer> interval: result) {
            ans[i][0] = interval.get(0);
            ans[i][1] = interval.get(1);
            i++;
        }
        return ans;
    }

    public int[][] sol1(int[][] intervals) {
        // sweep line algo - without using a map
        int max = 0;
        for (int[] entry : intervals)
            max = Math.max(max, entry[1]);
        max = (max + 1) * 2;
        int[] bucket = new int[max];
        for (int[] entry : intervals) {
            bucket[entry[0] * 2]++;
            bucket[entry[1] * 2 + 1]--;
        }
        List<int[]> answer = new ArrayList<>();
        int start = 0;
        for (int end = 1; end < max; end++) {
            bucket[end] += bucket[end - 1];
            if (bucket[end] != 0 && bucket[end - 1] == 0)
                start = end;
            else if (bucket[end] == 0 && bucket[end - 1] != 0)
                answer.add(new int[]{start / 2, (end - 1) / 2});
        }
        return answer.toArray(new int[answer.size()][]);
    }

    public int[][] sol2(int[][] intervals) {
        if (intervals == null)  return new int[][]{};
        int n = intervals.length;
        if (n < 2) return intervals;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts); // 左端点排序 O(nlogn)
        Arrays.sort(ends);   // 右端点排序

        int curStart = starts[0];
        List<int[]> ret = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (starts[i] > ends[i - 1]) { // 区间无重叠
                ret.add(new int[]{curStart, ends[i - 1]});
                curStart = starts[i]; // 新区间开始
            }
        }

        ret.add(new int[]{curStart, ends[n - 1]});
        return ret.toArray(new int[ret.size()][2]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(solution(arr)));
    }
}
