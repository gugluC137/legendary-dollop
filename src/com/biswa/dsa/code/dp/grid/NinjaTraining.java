package com.biswa.dsa.code.dp.grid;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/ninja-s-training_3621003
public class NinjaTraining {

    public int solWithRecursion(int day, int lastTask, int[][] points) {

        int maxPoints = 0;

        //base case
        if (day == 0) {
            for (int i = 0; i < 3; i++) {
                if (i != lastTask) {
                    maxPoints = Math.max(maxPoints, points[0][i]);
                }
            }
            return maxPoints;
        }

        for (int i =0; i < 3; i++) {
            if (i != lastTask) {
                int point = points[day][i] + solWithRecursion(day - 1, i, points);
                maxPoints = Math.max(maxPoints, point);
            }
        }

        return maxPoints;
    }

    public int solWithMemoization(int day, int lastTask, int[][] points, int[][] dp) {

        int maxPoints = 0;

        //base case
        if (day == 0) {
            for (int i = 0; i < 3; i++) {
                if (i != lastTask) {
                    maxPoints = Math.max(maxPoints, points[0][i]);
                }
            }
            return maxPoints;
        }

        if (dp[day][lastTask] != -1) return dp[day][lastTask];

        for (int i =0; i < 3; i++) {
            if (i != lastTask) {
                int point = points[day][i] + solWithRecursion(day - 1, i, points);
                maxPoints = Math.max(maxPoints, point);
            }
        }

        return dp[day][lastTask] = maxPoints;
    }

    public int solWithTabulation(int days, int noOfTasks, int[][] points) {

        int[][] dp = new int[days][noOfTasks+1];

        for (int i = 0; i <= noOfTasks; i++) {
            int maxPoints = 0;
            for (int j = 0; j < noOfTasks; j++) {
                if (j != i) {
                    maxPoints = Math.max(maxPoints, points[0][j]);
                }
            }
            dp[0][i] = maxPoints;
        }

        for (int i = 1; i < days; i++) {
            for (int j = 0; j <= noOfTasks; j++) {
                int maxPoints = 0;
                for (int k = 0; k < noOfTasks; k++) {
                    if (k != j) {
                        maxPoints = Math.max(maxPoints, points[i][k] + dp[i-1][k]);
                    }
                }
                dp[i][j] = maxPoints;
            }
        }

        return dp[days-1][noOfTasks];
    }

    public int solWithSpaceOptimisation(int days, int noOfTasks, int[][] points) {

        int[] prev = new int[noOfTasks+1];

        for (int i = 0; i <= noOfTasks; i++) {
            int maxPoints = 0;
            for (int j = 0; j < noOfTasks; j++) {
                if (j != i) {
                    maxPoints = Math.max(maxPoints, points[0][j]);
                }
            }
            prev[i] = maxPoints;
        }

        for (int i = 1; i < days; i++) {
            int[] cur = new int[noOfTasks+1];
            for (int j = 0; j <= noOfTasks; j++) {
                int maxPoints = 0;
                for (int k = 0; k < noOfTasks; k++) {
                    if (k != j) {
                        maxPoints = Math.max(maxPoints, points[i][k] + prev[k]);
                    }
                }
                cur[j] = maxPoints;
            }
            System.arraycopy(cur, 0, prev, 0, prev.length);
        }

        return prev[noOfTasks];
    }

    public static void main(String[] args) {
        NinjaTraining obj = new NinjaTraining();

        int[][] points = {{1,2,5}, {3,1,1}, {3,3,3}};
        int n = points.length;
        int lastTask = points[0].length;

        System.out.println(obj.solWithRecursion(n-1, lastTask, points));

        int[][] dp = new int[n][4];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(obj.solWithMemoization(n-1, lastTask, points, dp));

        System.out.println(obj.solWithTabulation(n, lastTask, points));
        System.out.println(obj.solWithSpaceOptimisation(n, lastTask, points));
    }
}
