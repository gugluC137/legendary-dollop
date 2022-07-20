package com.biswa.dsa.code.linkedlist.day7;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int curPos = 1, curVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curVal) {
                curVal = nums[i];
                nums[curPos] = nums[i];
                curPos++;
            }
        }

        return curPos;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};

        int k = removeDuplicates(arr);

        System.out.println(Arrays.toString(arr));
    }

}
