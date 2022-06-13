package com.biswa.dsa.code.array.day2;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        int i = 0;
        while (i < m) {
           if (nums2[0] < nums1[i]) {
                swap(nums1, nums2, i);
                sortNums2(nums2);
            }
            i++;
        }
        copyNums2(nums1, nums2, m);

    }

    private void swap(int[] nums1, int[] nums2, int pos1) {
        int temp = nums1[pos1];
        nums1[pos1] = nums2[0];
        nums2[0] = temp;
    }
    private void sortNums2(int[] nums2) {
        for (int i = 0; i < nums2.length-1 && nums2[i] > nums2[i+1]; i++) {
            int temp = nums2[i];
            nums2[i] = nums2[i+1];
            nums2[i+1] = temp;
        }
    }
    private void copyNums2(int[] nums1, int[] nums2, int m) {
        int i = m;
        for (int value: nums2) {
            nums1[i++] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        MergeSortedArrays obj = new MergeSortedArrays();
        obj.merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

}
