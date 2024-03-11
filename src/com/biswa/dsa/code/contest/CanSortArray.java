package com.biswa.dsa.code.contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static com.biswa.dsa.util.GenericUtils.swap;

public class CanSortArray {
    public boolean canSortArray(int[] nums) {
        boolean ans = true;

        boolean sorted;
        do {
            sorted = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i-1]) {
                    if (Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])) {
                        swap(nums, i, i-1);
                        sorted = false;
                    } else {
                        ans = false;
                        sorted = true;
                        break;
                    }
                }
            }

        } while (!sorted);

        return ans;
    }

    public int countSetBits(int num) {
        int c = 0;
        while (num > 0) {
//            c = c + (num & 1);
//            num = num >> 1;
            c += num & 1;
            num >>= 1;
        }

        return c;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,4,5};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
