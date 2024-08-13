package com.biswa.dsa.code.jumpgame;

//https://leetcode.com/problems/jump-game-vi/description/
public class JumpGame6 {
    //Wrong
    public int maxResultGreedy(int[] nums, int k) {
        int sum = 0;
        int pos = 0;
        while (pos < nums.length) {
            sum += nums[pos];
            int posWithMaxVal = pos+1;
            for (int m = pos+2; m < nums.length && m <= pos+k; m++) {
                if (nums[m] > nums[posWithMaxVal]) posWithMaxVal = m;
            }
            pos = posWithMaxVal;
        }

        return sum;
    }
}
