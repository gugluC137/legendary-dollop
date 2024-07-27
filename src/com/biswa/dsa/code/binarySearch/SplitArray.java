package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArray {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isPossible(nums, k, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public boolean isPossible(int[] nums, int k, int max) {
        int sum = 0;
        int c = 1;
        for (int n : nums) {
            if (sum + n <= max) {
                sum += n;
            } else {
                sum = n;
                c++;
            }
        }

        return c <= k;
    }
}
