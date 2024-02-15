package com.biswa.dsa.code.dp.OneD;

import java.util.Arrays;

public class MaxSumOfNonAdjacent {

    //TC: O(2^n)
    //SC: O(n) [only stack space]
    public int solWithRecursion(int n, int[] nums) {
        if (n == 0) return nums[n];
        if (n < 0) return 0;

        int pick = nums[n] + solWithRecursion(n-2, nums);
        int notPick = solWithRecursion(n - 1, nums);

        return Math.max(pick, notPick);
    }

    //TC: O(n)
    //SC: O(n) + O(n) [one for dp, one for stack space]
    public int solWithMemoization(int n, int[] nums, int[] dp) {
        if (n == 0) return nums[n];
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int pick = nums[n] + solWithRecursion(n-2, nums);
        int notPick = solWithRecursion(n - 1, nums);

        return dp[n] = Math.max(pick, notPick);
    }

    //TC: O(n)
    //SC: O(n) [only dp]
    public int solWithTabulation(int n, int[] nums) {

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    //TC: O(n)
    //SC: O(1)
    public int solWithSpaceOptimisation(int n, int[] nums) {

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int cur = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public static void main(String[] args) {
        MaxSumOfNonAdjacent obj = new MaxSumOfNonAdjacent();

        int[] nums = {2,1,4,9};
        int n = nums.length;

        System.out.println(obj.solWithRecursion(n-1, nums));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(obj.solWithMemoization(n-1, nums, dp));

        System.out.println(obj.solWithTabulation(n, nums));

        System.out.println(obj.solWithSpaceOptimisation(n, nums));
    }
}
