package com.biswa.dsa.code.array.day4;

import java.util.HashMap;
import java.util.Map;

public class SumProblem2 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numsMap.containsKey(other)) {
                ans[0] = i;
                ans[1] = numsMap.get(other);
                break;
            }
            numsMap.put(nums[i], i);
        }

        return ans;
    }

}
