package com.biswa.dsa.code.dp.stocks;

public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int buy = 0;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[sell]) {
                if (buy < sell) {
                    profit += prices[sell] - prices[buy];
                }
                buy = i;
            }
            sell = i;
        }

        if (sell > buy) {
            profit += prices[sell] - prices[buy];
        }

        return profit;
    }
}
