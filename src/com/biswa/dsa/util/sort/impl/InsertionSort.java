package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;

// Sort the given array using insertion sort. The idea behind
// insertion sort is that at the array is already sorted from
// [0, i] and you want to add the element at position i+1, so
// you 'insert' it at the appropriate location.
public class InsertionSort implements SortArray {

    @Override
    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }
}
