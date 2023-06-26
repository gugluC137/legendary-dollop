package com.biswa.dsa.code.random;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class SearchRange {

    //space: O(1)
    //Time: O(n), n = size of input array
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int pos = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(pos == -1) {
                    pos = i;
                    res[0] = pos;
                } else {
                    pos = i;
                }
            } else {
                if (pos != -1) {
                    break;
                }
            }
        }
        res[1] = pos;

        return res;
    }
}


