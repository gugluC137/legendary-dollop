package com.biswa.dsa.code.dp.stocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        return helper(0, 1, prices);
    }

    public int helper(int day, int canBuy, int[] prices) {
        //base case
        if (day == prices.length) return 0;

        //process
        int op1, op2;
        if (canBuy == 1) {
            op1 = - prices[day] + helper(day+1, 0, prices);
            op2 = helper(day+1, 1, prices);
        } else {
            op1 = prices[day] + helper(day+1, 1, prices);
            op2 = helper(day+1, 0, prices);
        }

        return Math.max(op1, op2);
    }

    public int maxProfitTabulation(int[] prices) {
        var days = prices.length;
        var dp = new int[2][days+1];
        dp[0][days] = 0;
        dp[1][days] = 0;

        for (var day = days-1; day >= 0; day--) {
            dp[0][day] = Math.max(prices[day] + dp[1][day+1], dp[0][day+1]);
            dp[1][day] = Math.max(-prices[day]+ dp[0][day+1], dp[1][day+1]);
        }

        return dp[1][0];
    }

    public int maxProfitSO(int[] prices) {
        var days = prices.length;
        var prev = new int[2];
        Arrays.fill(prev, 0);

        for (var day = days-1; day >= 0; day--) {
            var cur = new int[2];
            cur[0] = Math.max(prices[day] + prev[1], prev[0]);
            cur[1] = Math.max(-prices[day] + prev[0], prev[1]);

            prev = cur;
        }

        return prev[1];
    }
}
