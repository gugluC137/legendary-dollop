package com.biswa.dsa.code.dp;

import java.util.Arrays;

public class JumpGame1 {

    //recursive solution
    public boolean canJump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return canJumMemoization(nums, 0, dp);

        return canJumpTabulation(nums);
    }

    public boolean canJumpRecursive(int[] nums, int i) {
        //base case
        if (i == nums.length - 1) {
            return true;
        }

        //process
        int pos = i+1;
        while (pos < nums.length && pos <= i + nums[i]) {
            if (canJumpRecursive(nums, pos)) {
                return true;
            }
            pos++;
        }

        return false;
    }

    public boolean canJumMemoization(int[] nums, int i, int[] dp) {
        if (i == nums.length - 1) {
            return true;
        }

        //process
        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        int pos = i+1;
        while (pos < nums.length && pos <= i + nums[i]) {
            dp[pos] = canJumMemoization(nums, pos, dp) ? 1 : 0;
            if (dp[pos] == 1) {
                return true;
            }
            pos++;
        }

        return false;
    }

    public boolean canJumpTabulation(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        Arrays.fill(dp, -1);
        dp[l-1] = 1;

        for (int pos = l-2; pos >= 0; pos--) {
            boolean canReach = false;
            for (int i = pos+1; i < l && i <= pos + nums[pos]; i++) {
                if (dp[i] == 1) {
                    canReach = true;
                    break;
                }
            }
            dp[pos] = canReach ? 1 : 0;
        }

        return dp[0] == 1;
    }

    public boolean canJumpSpaceOptimised(int[] nums) {
        int l = nums.length;
        int canReachPoint = l-1;

        for (int pos = l-2; pos >= 0; pos--) {
            if (pos + nums[pos] >= canReachPoint) canReachPoint = pos;
        }

        return canReachPoint == 0;

    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};

        JumpGame1 obj = new JumpGame1();
        System.out.println(obj.canJump(nums1));
        System.out.println(obj.canJump(nums2));
    }
}
