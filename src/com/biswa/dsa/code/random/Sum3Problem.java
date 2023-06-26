package com.biswa.dsa.code.random;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class Sum3Problem {
    public List<List<Integer>> threeSumI(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length-2; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashset.contains(third)) {
                    List<Integer> res = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(res);
                    resultSet.add(res);
                }
                hashset.add(nums[j]);
            }
        }

        return resultSet.stream().toList();
    }

    public List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1, k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(res);

                    j++; k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return result;
    }
}
