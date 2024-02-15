package com.biswa.dsa.code.dp.stocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BuySellStock3 {
    public int maxProfit(int[] prices) {

        List<Integer> profitList = new ArrayList<>();
        int buy = 0;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[sell]) {
                if (buy < sell) {
                    profitList.add(prices[sell] - prices[buy]);
                }
                buy = i;
            }
            sell = i;
        }

        if (sell > buy) {
            profitList.add(prices[sell] - prices[buy]);
        }

        switch (profitList.size()) {
            case 0: return 0;
            case 1: return profitList.get(0);
            default:
                profitList.sort(Collections.reverseOrder());
                return profitList.get(0) + profitList.get(1);
        }

    }
}
