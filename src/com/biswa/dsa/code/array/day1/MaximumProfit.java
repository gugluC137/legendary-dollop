package com.biswa.dsa.code.array.day1;

import java.util.Arrays;
import java.util.List;

public class MaximumProfit {

    public static int maximumProfit(List<Integer> list) {
        int b, s, profit; //temp
        int buy, sell, maxProfit = 0; //final ans
        int len = list.size();
        int largestTillPoint = len-1;

        for (int i = len-2; i >= 0; i--) {
            b = i; s = largestTillPoint;
            profit = list.get(s) - list.get(b);

            if(profit > 0 && profit > maxProfit) {
                buy = b;
                sell = s;
                maxProfit = profit;
            }

            if(list.get(i) > list.get(largestTillPoint)) {
                largestTillPoint = i;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100, 1);
        System.out.println(maximumProfit(list));
    }
}
