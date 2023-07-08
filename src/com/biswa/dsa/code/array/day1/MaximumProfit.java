package com.biswa.dsa.code.array.day1;

import java.util.Arrays;
import java.util.List;

public class MaximumProfit {

    //Brute force will be to compare each day's buying price with selling price of all days beyond
    //2nd Brute force will be to find out the largest selling price after a certain day, selling on that day will give the max profit if you buy at the day
    //the 2nd approach leads to the solution provided below

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
