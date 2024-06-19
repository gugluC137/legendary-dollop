package com.biswa.dsa.code.daily;

import java.util.Arrays;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] fr = new int[26];
        Arrays.fill(fr, 0);
        for (char ch : tasks) {
            fr[ch - 65]++;
        }

        int[] lc = new int[26];
        Arrays.fill(lc, -1);

        int cycle = 1;
        boolean taskLeftToProcess = true;

        while (taskLeftToProcess) {
            int maxFreqTask = -1;
            //find max freq task now
            for (int i = 0; i < 26; i++) {
                if (fr[i] > 0
                    && (lc[i] == -1 || cycle - lc[i] > n)
                    && (maxFreqTask == -1 || fr[maxFreqTask] < fr[i])) {
                    maxFreqTask = i;
                }
            }

            if (maxFreqTask != -1) {
                fr[maxFreqTask]--;
                lc[maxFreqTask] = cycle;
            }

            taskLeftToProcess = Arrays.stream(fr).anyMatch(a -> a != 0);
            if (taskLeftToProcess) cycle++;
        }

        return cycle;
    }

    public static void main(String[] args) {
        char[] ar1 = {'A','A','A','B','B','B','C','C','C','D','D','E'};
        char[] ar2 = {'A','A','A','B','B','B'};

        System.out.println(new TaskScheduler().leastInterval(ar1, 2));
        System.out.println(new TaskScheduler().leastInterval(ar2, 2));
    }
}
