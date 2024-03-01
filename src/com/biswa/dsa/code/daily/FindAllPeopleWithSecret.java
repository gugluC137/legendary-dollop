package com.biswa.dsa.code.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        parents[firstPerson] = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        int meetIdx = 0;
        List<Integer> tempList = new ArrayList<>();
        while (meetIdx < meetings.length) {
            int curTime = meetings[meetIdx][2];
            while (meetIdx < meetings.length && curTime == meetings[meetIdx][2]) {
                int p1 = find(parents, meetings[meetIdx][0]);
                int p2 = find(parents, meetings[meetIdx][1]);

                parents[Math.max(p1, p2)] = Math.min(p1, p2);
                tempList.add(meetings[meetIdx][0]);
                tempList.add(meetings[meetIdx][1]);

                meetIdx++;
            }

            for (int i : tempList) {
                if (find(parents, i) == 0) {
                    parents[i] = 0;
                } else {
                    parents[i] = i;
                }
            }

            tempList.clear();
        }

        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (parents[i] == 0) ans.add(i);
        }

        return ans;
    }

    public int find(int[] p, int n) {
        while (p[n] != n) {
            n = p[n];
        }

        return n;
    }

    public static void main(String[] args) {
        int[][] meetings = {{1,4,3}, {0, 4, 3}};

        System.out.println(new FindAllPeopleWithSecret().findAllPeople(5, meetings, 3));
    }
}
