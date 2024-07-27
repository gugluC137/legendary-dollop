package com.biswa.dsa.code.jumpgame;

public class JumpGame2 {
    public int jumpTabulation(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[l-1] = 0;

        for (int pos = l-2; pos >= 0; pos--) {
            int minJumps = Integer.MAX_VALUE;
            for (int x = pos+1; x < l && x <= pos + nums[pos]; x++){
                if (minJumps > dp[x]) minJumps = dp[x];
            }
            if (minJumps != Integer.MAX_VALUE) minJumps++;
            dp[pos] = minJumps;
        }

        return dp[0];
    }

    public int jumpOptimised(int[] nums) {
        int pos = nums.length - 1;
        int minJumps = 0;

        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    break;
                }
            }
            minJumps++;
        }

        return minJumps;
    }

    //TC: O(N)
    //SC: O(1)
    public int jumpGreedy(int[] nums) {
        int l = 0, r = 0;
        int jumps = 0;
        while (r < nums.length-1) {
            int max = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                max = Math.max(max, i + nums[i]);
            }
            l = r+1;
            r = max;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};

        JumpGame2 obj = new JumpGame2();
        System.out.println(obj.jumpOptimised(nums1));
    }
}
