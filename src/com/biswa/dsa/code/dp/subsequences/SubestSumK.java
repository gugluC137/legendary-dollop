package com.biswa.dsa.code.dp.subsequences;

//https://www.codingninjas.com/studio/problems/1550954
public class SubestSumK {

    public boolean solWithRecursion(int n, int k, int[] arr) {
        if (k == 0) return true;
        if (n == 0) return arr[n] == k;

        boolean pick = false;
        if (k >= arr[n]) {
            pick = solWithRecursion(n-1, k - arr[n], arr);
        }
        boolean notPick = solWithRecursion(n-1, k, arr);

        return pick || notPick;
    }

    public boolean solWithMemoization(int n, int k, int[] arr, int[][] dp) {
        if (k == 0) return true;
        if (n == 0) return arr[n] == k;

        if (dp[n][k] != -1) {
            if (dp[n][k] == 0) return false;
            else return true;
        }

        boolean pick = false;
        if (k >= arr[n]) {
            pick = solWithMemoization(n-1, k - arr[n], arr, dp);
        }
        boolean notPick = solWithMemoization(n-1, k, arr, dp);

        if (pick || notPick) dp[n][k] = 1;
        else dp[n][k] = 0;

        return pick || notPick;
    }

    public boolean solWithTabulation(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k+1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = arr[i] == j;
                } else {
                    boolean pick = false;
                    if (j >= arr[i]) {
                        pick = dp[i-1][j - arr[i]];
                    }
                    boolean notPick = dp[i-1][j];

                    dp[i][j] = pick || notPick;
                }
            }
        }

        return dp[n-1][k];
    }

    public boolean solWithSpaceOptimisation(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        for (int i = 1; i <= k; i++) {
            prev[i] = arr[0] == i;
        }

        for (int i = 1; i < n; i++) {
            boolean[] cur = new boolean[k+1];
            cur[0] = true;
            for (int j = 1; j <= k; j++) {
                boolean pick = false;
                if (j >= arr[i]) {
                    pick = prev[j - arr[i]];
                }
                boolean notPick = prev[j];

                cur[j] = pick || notPick;
            }
            prev = cur;
        }

        return prev[k];
    }

}
