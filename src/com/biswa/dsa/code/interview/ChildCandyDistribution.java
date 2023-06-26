package com.biswa.dsa.code.interview;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
public class ChildCandyDistribution {
    public int minNumberOfCandies(int[] ratings) {
        if (ratings.length == 1) return 1;

        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                res[i] = res[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && res[i] <= res[i+1]) {
                res[i] = res[i+1] + 1;
            }
        }

        return Arrays.stream(res).sum();
    }
}
