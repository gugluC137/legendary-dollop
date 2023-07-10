package com.biswa.dsa.code.dp;

import java.util.Arrays;

public class Fibonacci {

    //TC: exponential, overlapping problems are re-calculated
    //SC: O(N), on;y stack space
    public long fibRecursive(long n) {
        if (n <= 1) return n;

        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    //TC: O(N), overlapping problems are not re-calculated
    //SC: O(N) + O(N), stack space and dp array
    public long fibRecursiveWithMemoization(long n, long[] dp) {
        if (n <= 1) return n;

        if (dp[(int)n] != -1) return dp[(int)n];

        return dp[(int)n] = fibRecursiveWithMemoization(n-1, dp) + fibRecursiveWithMemoization(n-2, dp);
    }

    //TC: O(N)
    //SC: O(N), only dp array
    public long fibWithTabulation(int n) {
        long[] dp = new long[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //TC: O(N)
    //SC: O(1)
    public long fibSPaceOptimised(int n) {
        long prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            long cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        int n = 5;
        System.out.println(obj.fibSPaceOptimised(n));
    }
}
