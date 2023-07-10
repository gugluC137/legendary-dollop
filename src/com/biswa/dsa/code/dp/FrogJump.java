package com.biswa.dsa.code.dp;

import java.util.Arrays;

public class FrogJump {
    public int frogJumpRecursive(int n, int[] ht) {
        //base case
        if (n == 0) return 0;

        int singleStep = frogJumpRecursive(n-1, ht) + Math.abs(ht[n] - ht[n-1]);
        int doubleStep = Integer.MAX_VALUE;

        if (n > 1)
            doubleStep = frogJumpRecursive(n-2, ht) + Math.abs(ht[n] - ht[n-2]);

        return Math.min(singleStep, doubleStep);
    }

    public int frogJumpMemoization(int n, int[] ht, int[] dp) {
        //base case
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int singleStep = frogJumpMemoization(n-1, ht, dp) + Math.abs(ht[n] - ht[n-1]);
        int doubleStep = Integer.MAX_VALUE;

        if (n > 1)
            doubleStep = frogJumpMemoization(n-2, ht, dp) + Math.abs(ht[n] - ht[n-2]);

        return dp[n] = Math.min(singleStep, doubleStep);
    }

    public int frogJumpTabulation(int n, int[] ht) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int singleStep = dp[i-1] + Math.abs(ht[i] - ht[i-1]);
            int doubleStep = Integer.MAX_VALUE;

            if (i > 1)
                doubleStep = dp[i-2] + Math.abs(ht[i] - ht[i-2]);

            dp[i] = Math.min(singleStep, doubleStep);
        }

        return dp[n-1];
    }

    public int frogJumpSpaceOptimised(int n, int[] ht) {

        int prev1 = 0, prev2 = 0;

        for (int i = 1; i < n; i++) {
            int singleStep = prev1 + Math.abs(ht[i] - ht[i-1]);
            int doubleStep = Integer.MAX_VALUE;

            if (i > 1)
                doubleStep = prev2 + Math.abs(ht[i] - ht[i-2]);

            int cur = Math.min(singleStep, doubleStep);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public static void main(String[] args) {
        FrogJump obj = new FrogJump();

        int[] ht = {10,20,30,10};
        int n = ht.length - 1;

        System.out.println(obj.frogJumpRecursive(n, ht));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(obj.frogJumpMemoization(n, ht, dp));

        System.out.println(obj.frogJumpTabulation(n+1, ht));
    }
}
