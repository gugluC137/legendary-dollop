package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;
import java.util.Arrays;

public class QuickSortWithLomutoPartition implements SortArray {

    @Override
    public void sort(int[] arr) {
        if (arr == null) return;
        quicksort(arr, 0, arr.length-1);
    }

    private void quicksort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            /* splitPoint is partitioning index,
            arr[splitPoint] is now at right place */
            int splitPoint = lomutoPartition(arr, lo, hi);
            quicksort(arr, lo, splitPoint-1);
            quicksort(arr, splitPoint+1, hi);
        }
    }

    /* This function takes last element as
    pivot, places the pivot element at its
    correct position in sorted array, and
    places all smaller (smaller than pivot)
    to left of pivot and all greater elements
    to right of pivot */
    private int lomutoPartition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];

        // Index of smaller element
        int i = lo-1;

        for (int j = lo; j <= hi-1; j++) {
            // If current element is smaller
            // than or equal to pivot
            if (arr[j] <= pivot) { // change <= to > for decreasing order
                i++; // increment index of
                // smaller element
                swap(arr, i, j);
            }
        }

        int pivotPosition = i+1;
        swap(arr, hi, pivotPosition);
        return pivotPosition;
    }

    public static void main(String[] args) {
        int[] array = {-1, -8};
        System.out.println(Arrays.toString(array));
        QuickSortWithLomutoPartition obj = new QuickSortWithLomutoPartition();
        obj.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
