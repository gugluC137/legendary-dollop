package com.biswa.dsa.code.dp.stocks;

import java.util.Arrays;

public class BuySellStock4 {
    public int maxProfit(int[] prices, int k) {
        return helper(0, 1, k, prices);
    }

    public int helper(int day, int canBuy, int cap, int[] prices) {
        //base case
        if (day == prices.length) return 0;
        if (cap == 0) return 0;

        //process
        int op1, op2;
        if (canBuy == 1) {
            op1 = -prices[day] + helper(day+1, 0, cap, prices);
            op2 = helper(day+1, 1, cap, prices);
        } else {
            op1 = prices[day] + helper(day+1, 1, cap-1, prices);
            op2 = helper(day+1, 0, cap, prices);
        }

        return Math.max(op1, op2);
    }

    public int maxProfitTabulation(int k, int[] prices) {
        var days = prices.length;
        var dp = new int[days+1][k+1][2];

        //base cases
        for (var i = 0; i <= k; i++) {
            Arrays.fill(dp[days][i], 0);
        }
        for (var i = 0; i <= days; i++) {
            Arrays.fill(dp[i][0], 0);
        }

        //process
        for (var day = days-1; day >= 0; day--) {
            for (var cap = 1; cap <= k; cap++) {
                dp[day][cap][1] = Math.max(-prices[day] + dp[day+1][cap][0], dp[day+1][cap][1]);
                dp[day][cap][0] = Math.max(prices[day] + dp[day+1][cap-1][1], dp[day+1][cap][0]);
            }
        }

        return dp[0][k][1];
    }

    public int maxProfitSO(int k, int[] prices) {
        var days = prices.length;
        var prev = new int[k+1][2];

        //base case
        for (var i = 0; i <= k; i++) {
            Arrays.fill(prev[i], 0);
        }

        //process
        for (var day = days-1; day >= 0; day--) {
            var cur = new int[k+1][2];
            for (var cap = 1; cap <= k; cap++) {
                cur[cap][1] = Math.max(-prices[day] + prev[cap][0], prev[cap][1]);
                cur[cap][0] = Math.max(prices[day] + prev[cap-1][1], prev[cap][0]);
            }

            prev = cur;
        }

        return prev[k][1];
    }


}
