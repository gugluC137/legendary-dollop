package com.biswa.dsa.code.binarySearch;

//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElementInArray {
    /*
    linear approach: scan the elements, return the element nums[i] for which nums[i-1] != nums[i] != nums[i+1]
    Binary Search approach:
    How to eliminate one portion ? since all elements are in couples expect one,
    every couple to the left of single element will be at idx (even, odd).
    and every element to the right will be at  (odd, even)
     */
    public int singleNonDuplicate(int[] nums) {
        //edge conditions:
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int low = 1, high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low =  mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
