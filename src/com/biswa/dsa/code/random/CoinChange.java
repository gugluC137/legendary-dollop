package com.biswa.dsa.code.random;


public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        return solve(coins, amount, 0);
    }

    public static int solve(int[] coins, int amount, int idx) {
        if (amount == 0) return 0;
        if (idx == coins.length) return -1;

        int d = amount / coins[idx];
        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= d; i++) {
            int c = solve(coins, amount - coins[idx]*i, idx+1);
            if (c != -1) {
                count = Math.min(count, c+i);
            }
        }

        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public static void main(String[] args) {
        //Write Code here
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(CoinChange.coinChange(coins, amount));
    }
}
