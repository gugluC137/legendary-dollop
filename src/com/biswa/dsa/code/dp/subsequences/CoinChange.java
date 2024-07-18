package com.biswa.dsa.code.dp.subsequences;


import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] ar : dp) {
            Arrays.fill(ar, Integer.MAX_VALUE);
        }

        int ans = solveMemoization(coins, amount, coins.length-1, dp);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }

    public static int solveRecursion(int[] coins, int amount, int idx) {
        //base conditions
        if (amount == 0) return 0;
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return amount/coins[idx];
            } else {
                return Integer.MAX_VALUE-1;
            }
        }

        //process
        int take = Integer.MAX_VALUE;
        if (amount >= coins[idx]) {
            take = 1 + solveRecursion(coins, amount-coins[idx], idx);
        }

        int notTake = solveRecursion(coins, amount, idx-1);

        return Math.min(take, notTake);
    }

    public static int solveMemoization(int[] coins, int amount, int idx, int[][] dp) {
        //base conditions
        if (amount == 0) return 0;
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return amount/coins[idx];
            } else {
                return Integer.MAX_VALUE-1;
            }
        }

        if (dp[idx][amount] != Integer.MAX_VALUE) return dp[idx][amount];

        //process
        int take = Integer.MAX_VALUE;
        if (amount >= coins[idx]) {
            take = 1 + solveMemoization(coins, amount-coins[idx], idx, dp);
        }

        int notTake = solveMemoization(coins, amount, idx-1, dp);

        return dp[idx][amount] = Math.min(take, notTake);
    }

    public static int coinChangeTabulation(int[] coins, int amount) {
        var dp = new int[coins.length][amount+1];
        //base cases
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i/coins[0];
            else
                dp[0][i] = Integer.MAX_VALUE-1;
        }
        //if (amount==0)
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if (j-coins[i] >= 0) {
                    take = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[coins.length-1][amount] == Integer.MAX_VALUE-1 ? -1 : dp[coins.length-1][amount];
    }

    public static int coinChangeSO(int[] coins, int amount) {
        var prev = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i/coins[0];
            } else {
                prev[i] = Integer.MAX_VALUE-1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            var cur = new int[amount+1];
            cur[0] = 0;
            for (int j = 1; j <= amount; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if (j - coins[i] >= 0) {
                    take = 1 + cur[j-coins[i]];
                }

                cur[j] = Math.min(take, notTake);
            }

            prev = cur;
        }

        return prev[amount] == Integer.MAX_VALUE-1 ? -1 : prev[amount];
    }

    public static void main(String[] args) {
        //Write Code here
        int[] coins = {186,419,83,408};
        int[] coins2 = {411,412,413,414,415,416,417,418,419,420,421,422};
        int[] coins3 = {2};
        int amount = 6249;
        int amount2 = 9864;
        int amount3 = 3;
        System.out.println(CoinChange.coinChangeSO(coins, amount));
        System.out.println(CoinChange.coinChangeSO(coins2, amount2));
        System.out.println(CoinChange.coinChangeTabulation(coins3, amount3));
    }
}
