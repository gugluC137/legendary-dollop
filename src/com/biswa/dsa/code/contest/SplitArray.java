package com.biswa.dsa.code.contest;

import java.util.Arrays;

public class SplitArray {
    public boolean isPossibleToSplit(int[] nums) {
        int[] f = new int[101];
        Arrays.fill(f, 0);

        for (int num : nums) {
            f[num]++;
            if (f[num] > 2) {
                return false;
            }
        }

        return true;
    }
}
