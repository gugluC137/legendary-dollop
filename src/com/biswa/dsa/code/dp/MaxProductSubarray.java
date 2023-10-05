package com.biswa.dsa.code.dp;

import java.util.Arrays;

public class MaxProductSubarray {
    public int solWithRecursion(int idx, int pickedLast, int[] nums) {
        if (idx == -1) return 1;

        int pick = nums[idx] * solWithRecursion(idx-1, 1, nums);
        int notPick = Integer.MIN_VALUE;
        if (pickedLast == 0) {
            notPick = solWithRecursion(idx-1, 0, nums);
        }

        return Math.max(pick, notPick);
    }

    public int solWithMemoization(int idx, int pickedLast, int[] nums, int[][] dp) {
        if (idx == -1) return 1;

        if (dp[idx][pickedLast] != -1) return dp[idx][pickedLast];

        int pick = nums[idx] * solWithMemoization(idx-1, 1, nums, dp);
        int notPick = Integer.MIN_VALUE;
        if (pickedLast == 0) {
            notPick = solWithMemoization(idx-1, 0, nums, dp);
        }

        return dp[idx][pickedLast] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        MaxProductSubarray obj = new MaxProductSubarray();
        int[] arr = {-2, 0, -1};
        System.out.println(obj.solWithRecursion(arr.length-1, 0, arr));

        int[][] dp = new int[arr.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(obj.solWithMemoization(arr.length-1, 0, arr, dp));
    }
}
