package com.biswa.dsa.code.dp.stocks;

public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int days = prices.length;
        int[] dp = new int[days];
        int maxSellPrice = prices[days-1];
        int day = days-2;
        while (day >= 0) {
            dp[day] = maxSellPrice;
            if (prices[day] > maxSellPrice) {
                maxSellPrice = prices[day];
            }
            day--;
        }

        for (int i = 0; i <= days-2; i++) {
            int profit = dp[i] - prices[i];
            if (profit > maxProfit) maxProfit = profit;
        }

        return maxProfit;
    }

    public int maxProfitSO(int[] prices) {
        int maxProfit = 0;

        int maxSellPrice = prices[prices.length-1];

        for (int day = prices.length-2; day >= 0; day--) {
            //checking for profit
            int profit = maxSellPrice - prices[day];
            if (profit > maxProfit) maxProfit = profit;

            //update max selling price available for the prev day
            if (prices[day] > maxSellPrice) {
                maxSellPrice = prices[day];
            }
        }

        return maxProfit;
    }
}
