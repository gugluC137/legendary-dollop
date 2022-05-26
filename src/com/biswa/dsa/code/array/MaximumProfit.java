package com.biswa.dsa.code.array;

import java.util.Arrays;
import java.util.List;

public class MaximumProfit {

    public static int maximumProfit(List<Integer> list) {

        int[] nextGreater = new int[list.size()-1];
        Arrays.fill(nextGreater, 0);

        int l = list.size()-1;
        for (int i = list.size()-1; i >= 0; i--) {
            if(list.get(l) <= list.get(i)) {
                l = i;
            }
            nextGreater[i] = l;
        }

        int ans = list.get(nextGreater[0]) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int p = list.get(nextGreater[i]) - list.get(i);
            if(p > ans) ans = p;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
