package com.biswa.dsa.code.dp;

import javax.swing.*;
import java.util.Arrays;

public class LongestIncreasingSubsq {
    public int solWithRecursion(int i,  int last_index, int[] nums) {

        if (i >= nums.length) return 0;

        int pick = 0;
        if (last_index == -1 || nums[last_index] < nums[i]) {
            pick = 1 + solWithRecursion(i+1, i, nums);
        }

        int not_pick = solWithRecursion(i+1, last_index, nums);

        return Math.max(pick, not_pick);
    }

    public int solWithMemoization(int i,  int last_index, int[] nums, int[][] dp) {

        if (i == nums.length) return 0;

        if (dp[i][last_index] != -1) return dp[i][last_index];

        int pick = 0;
        if (last_index == 0 || nums[last_index-1] < nums[i]) {
            pick = 1 + solWithMemoization(i+1, i+1, nums, dp);
        }

        int not_pick = solWithMemoization(i+1, last_index, nums, dp);

        return dp[i][last_index] = Math.max(pick, not_pick);
    }

    public int solWithTabulation(int[] nums) {
        int l = nums.length;
        int[][] dp = new int[l+1][l+1];

        Arrays.fill(dp[l], 0);

        for (int i = l-1; i >= 0; i--) {
            for (int j = 0; j <= l; j++) {
                int pick = 0;
                if (j == 0 || nums[j-1] < nums[i]) {
                    pick = 1 + dp[i+1][i+1];
                }
                int not_pick = dp[i+1][j];

                dp[i][j] = Math.max(pick, not_pick);
            }
        }

        return dp[0][0];
    }

    public int solWithSpaceOptimisation(int[] nums) {
        int l = nums.length;
        int[] prev = new int[l+1];

        Arrays.fill(prev, 0);

        for (int i = l-1; i >= 0; i--) {
            int[] cur = new int[l+1];
            for (int j = 0; j <= l; j++) {
                int pick = 0;
                if (j == 0 || nums[j-1] < nums[i]) {
                    pick = 1 + prev[i+1];
                }

                int not_pick = prev[j];
                cur[j] = Math.max(pick, not_pick);
            }
            prev = cur;
        }

        return prev[0];
    }
}
