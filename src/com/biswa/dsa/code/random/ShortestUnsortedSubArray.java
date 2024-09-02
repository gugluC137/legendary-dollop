package com.biswa.dsa.code.random;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
public class ShortestUnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        var n = nums.length;

        var end = -1;
        var max = nums[0];
        for (var i = 1; i < n; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        var start = 0;
        var min = nums[n-1];
        for (var i = n-2; i >= 0; i--) {
            if (min < nums[i]) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        return end - start + 1;
    }
}
