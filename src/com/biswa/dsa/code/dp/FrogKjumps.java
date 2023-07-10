package com.biswa.dsa.code.dp;

import java.util.Arrays;

public class FrogKjumps {
    public int frogJumpRecursive(int n, int k, int[] ht) {
        //base case
        if (n == 0) return 0;

        int minStep = Integer.MAX_VALUE;
        //check for all possible steps, until k possibilities or jumping i steps goes beyond 0
        for (int i = 1; n-i >= 0 && i <= k; i++) {
            minStep = Math.min(minStep, frogJumpRecursive(n-i, k, ht) + Math.abs(ht[n] - ht[n-i]));
        }

        return minStep;
    }

    public int frogJumpMemoization(int n, int k, int[] ht, int[] dp) {
        //base case
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int minStep = Integer.MAX_VALUE;
        //check for all possible steps, until k possibilities or jumping i steps goes beyond 0
        for (int i = 1; n-i >= 0 && i <= k; i++) {
            minStep = Math.min(minStep, frogJumpMemoization(n-i, k, ht, dp) + Math.abs(ht[n] - ht[n-i]));
        }

        return dp[n] = minStep;
    }

    public int frogJumpTabulation(int n, int k, int[] ht) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minStep = Integer.MAX_VALUE;
            //check for all possible steps, until k possibilities or jumping i steps goes beyond 0
            for (int j = 1; i-j >= 0 && j <= k; j++) {
                minStep = Math.min(minStep, dp[i-j] + Math.abs(ht[i] - ht[i-j]));
            }

            dp[i] = minStep;
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        FrogKjumps obj = new FrogKjumps();

        int[] ht = {10,20,30,10};
        int n = ht.length - 1;
        int k = 3;

        System.out.println(obj.frogJumpRecursive(n, k, ht));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(obj.frogJumpMemoization(n, k, ht, dp));

        System.out.println(obj.frogJumpTabulation(n+1, k, ht));
    }
}
