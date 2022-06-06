package com.biswa.dsa.uncategorised;

/*
You are given a 0-indexed array nums that consists of n distinct positive integers.
Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].

It is guaranteed that in the ith operation:
operations[i][0] exists in nums.
operations[i][1] does not exist in nums.

constraints:
n == nums.length
m == operations.length
1 <= n, m <= 105
********* All the values of nums are distinct. ********* this allows the solution with hashmap
operations[i].length == 2
1 <= nums[i], operations[i][0], operations[i][1] <= 106
operations[i][0] will exist in nums when applying the ith operation.
operations[i][1] will not exist in nums when applying the ith operation.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReplaceElements {

    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> numPositions = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numPositions.put(nums[i], i);
        }

        for (int[] operation : operations) {
            int positionOfOperation0 = numPositions.get(operation[0]);
            numPositions.remove(operation[0]);
            numPositions.put(operation[1], positionOfOperation0);
            nums[positionOfOperation0] = operation[1];
        }

        return nums;
    }

    public int[] optSol(int[] nums, int[][] operations) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        for (int[] op: operations) {
            set.remove(op[0]);
            set.add(op[1]);
        }
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        for (int num: set) {
            res[i++] = num;
        }
        return res;
    }

}
