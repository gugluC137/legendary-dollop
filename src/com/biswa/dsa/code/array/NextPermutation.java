package com.biswa.dsa.code.array;

import static com.biswa.dsa.util.GenericUtils.swap;

import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    /*
     * find the position where we can move to the next permutation.
     * -> pos = i, if arr[i] < arr[i+1]
     * find the next highest digit after arr[i] between i and N-1
     * swap that with arr[i]
     * arrange the sequence from i+1 to N-1 in ascending
     */
    public static List<Integer> nextPermutation(List<Integer> permutation) {

        int pos = -1, n = permutation.size();

        for (int i = n-2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i+1)) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            for (int i = n-1; i > pos; i--) {
                if (permutation.get(i) > permutation.get(pos)) {
                    swap(permutation, i, pos);
                    break;
                }
            }
        }
        for (int i = pos+1, j = n-1; i < j; i++, j--) {
            swap(permutation, i, j);
        }

        return  permutation;
    }

    public static int[] nextPermutation(int[] nums) {

        int pos = -1, n = nums.length;

        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            for (int i = n-1; i > pos; i--) {
                if (nums[i] > nums[pos]) {
                    swap(nums, i, pos);
                    break;
                }
            }
        }
        for (int i = pos+1, j = n-1; i < j; i++, j--) {
            swap(nums, i, j);
        }

        return nums;
    }

    public static void main(String[] args) {
        List<Integer> p = Arrays.asList(4,5,3,6,2,1);
        System.out.println(nextPermutation(p));

        int[] arr = {4,5,3,6,2,1};
        System.out.println(Arrays.toString(nextPermutation(arr)));
    }

}