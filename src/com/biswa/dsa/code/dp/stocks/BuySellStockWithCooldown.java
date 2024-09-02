package com.biswa.dsa.code.dp.stocks;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        return helper(0, 1, prices);
    }

    public int helper(int day, int canBuy ,int[] prices) {
        //base case
        if (day >= prices.length) return 0;

        //process
        int op1, op2;
        if (canBuy == 1) {
            op1 = -prices[day] + helper(day+1, 0, prices);
            op2 = helper(day+1, 1, prices);
        } else {
            op1 = prices[day] + helper(day+2, 1, prices);
            op2 = helper(day+1, 0, prices);
        }

        return Math.max(op1, op2);
    }
}
