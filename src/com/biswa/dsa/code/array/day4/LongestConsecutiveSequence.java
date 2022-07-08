package com.biswa.dsa.code.array.day4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }

        int maxCount = 1, count = 0;
        for (int num : nums) {
            if (numSet.contains(num - 1))
                continue;

            if (numSet.contains(num + 1)) {
                count = getConsecutiveCount(num + 1, numSet);
            }

            if (count > maxCount)
                maxCount = count;
        }

        return maxCount;
    }

    private static int getConsecutiveCount(int num, Set<Integer> numSet) {
        int count = 2;

        while (numSet.contains(++num)) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }

}
