package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;

// Sort the array using bubble sort. The idea behind
// bubble sort is to look for adjacent indexes which
// are out of place and interchange their elements
// until the entire array is sorted.
public class BubbleSort implements SortArray {

    @Override
    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        boolean sorted;
        do {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i - 1, i);
                    sorted = false;
                }
            }
        } while (!sorted);
    }


}
