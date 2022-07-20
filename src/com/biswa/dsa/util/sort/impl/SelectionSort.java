package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;

public class SelectionSort implements SortArray {

    @Override
    public void sort(int[] arr) {
        if (arr == null) return;
        final int N = arr.length;

        for (int i = 0; i < N; i++) {
            // Find the index beyond i with a lower value than i
            int swapIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[swapIndex]) {
                    swapIndex = j;
                }
            }
            swap(arr, i, swapIndex);
        }
    }
}
