package com.biswa.dsa.code.contest;

// Divide an Array Into Subarrays With Minimum Cost I
public class MinCostSubArrays {
    public int minimumCost(int[] nums) {

        int ans = nums[0];
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (s1 > nums[i]) {
                s2 = s1;
                s1 = nums[i];
            } else if (s2 > nums[i]) {
                s2 = nums[i];
            }
        }

        return ans + s1 + s2;
    }
}
