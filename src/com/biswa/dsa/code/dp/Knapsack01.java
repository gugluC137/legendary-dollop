package com.biswa.dsa.code.dp;

public class Knapsack01 {

    public int solWithRecursion(int[] weight, int[] value, int n, int maxWeight) {
        if (maxWeight == 0) return 0;
        if (n == 0) {
            if (maxWeight >= weight[n]) return value[n];
            else return 0;
        }

        int pick = 0;
        if (maxWeight >= weight[n]) {
            pick = value[n] + solWithRecursion(weight, value, n-1, maxWeight-weight[n]);
        }
        int notPick = solWithRecursion(weight, value, n-1, maxWeight);

        return Math.max(pick, notPick);
    }

    public int solWithMemoization(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {
        if (maxWeight == 0) return 0;
        if (n == 0) {
            if (maxWeight >= weight[n]) return value[n];
            else return 0;
        }

        if (dp[n][maxWeight] != -1) return dp[n][maxWeight];

        int pick = 0;
        if (maxWeight >= weight[n]) {
            pick = value[n] + solWithMemoization(weight, value, n-1, maxWeight-weight[n], dp);
        }
        int notPick = solWithMemoization(weight, value, n-1, maxWeight, dp);

        return dp[n][maxWeight] = Math.max(pick, notPick);
    }

    public int solWithTabulation(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < maxWeight+1; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < maxWeight+1; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if (j >= weight[i]) {
                    pick = value[i] + dp[i-1][j-weight[i]];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][maxWeight];
    }

    public int solWithSpaceOptimisation(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];
        prev[0] = 0;
        for (int i = 1; i < maxWeight+1; i++) {
            prev[i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[maxWeight+1];
            cur[0] = 0;
            for (int j = 1; j < maxWeight+1; j++) {
                int notPick = prev[j];
                int pick = 0;
                if (j >= weight[i]) {
                    pick = value[i] + prev[j-weight[i]];
                }

                cur[j] = Math.max(pick, notPick);
            }
            prev = cur;
        }

        return prev[maxWeight];
    }

    public int solWithSpaceOptimisationI(int[] weight, int[] value, int n, int maxWeight) {
        int[] dp = new int[maxWeight+1];
        dp[0] = 0;
        for (int i = 1; i < maxWeight+1; i++) {
            dp[i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = maxWeight; j >= 0; j--) {
                int notPick = dp[j];
                int pick = 0;
                if (j >= weight[i]) {
                    pick = value[i] + dp[j - weight[i]];
                }

                dp[j] = Math.max(pick, notPick);
            }
        }

        return dp[maxWeight];
    }

}
