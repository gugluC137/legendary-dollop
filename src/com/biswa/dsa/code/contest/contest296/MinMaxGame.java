package com.biswa.dsa.code.contest.contest296;

import com.biswa.dsa.util.model.enums.Side;
import java.util.Arrays;

public class MinMaxGame {

    public int solution(int[] nums) {
        return game(nums, Side.LEFT);
    }

    private int game(int[] arr, Side side) {
        if (arr.length == 1) return arr[0];

        int mid = arr.length/2;
        int leftResult = game(Arrays.copyOfRange(arr, 0, mid), Side.LEFT);
        int rightResult = game(Arrays.copyOfRange(arr, mid, arr.length), Side.RIGHT);

        return Side.LEFT.equals(side)
          ? Math.min(leftResult, rightResult)
          : Math.max(leftResult, rightResult);
    }


    //iterative solution from leetcode
    public int iterativeSol(int[] nums) {
        while (nums.length > 1) {
            int n = nums.length;
            int[] newNums = new int[n/2];
            for (int i = 0; i < n/2; i++) {
                if (i % 2 == 0) newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = newNums;
        }
        return nums[0];
    }

}