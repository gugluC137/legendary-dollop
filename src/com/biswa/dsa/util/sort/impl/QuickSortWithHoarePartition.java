package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;
import java.util.Arrays;

public class QuickSortWithHoarePartition implements SortArray {

    @Override
    public void sort(int[] arr) {
        if (arr == null) return;
        quicksort(arr, 0, arr.length - 1);
    }

    // Sort interval [lo, hi] in-place recursively
    private void quicksort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            /* splitPoint is partitioning index,
               arr[splitPoint] is now at right place */
            int splitPoint = hoarePartition(ar, lo, hi);
            quicksort(ar, lo, splitPoint);
            quicksort(ar, splitPoint + 1, hi);
        }
    }

     /* This function takes first element as pivot, and
       places all the elements smaller than the pivot on the
       left side and all the elements greater than the pivot
       on the right side. It returns the index of the last
       element on the smaller side */
    private int hoarePartition(int[] ar, int lo, int hi) {
        int pivot = ar[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (ar[i] < pivot); // change < to > for decreasing order
            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (ar[j] > pivot); // change > to < for decreasing order

            if (i < j) swap(ar, i, j);
            else return j;
        }
    }

    public static void main(String[] args) {
        int[] array = {-10, 4, 6, 5, 8, -13, 10, 3};
        System.out.println(Arrays.toString(array));
        QuickSortWithHoarePartition obj = new QuickSortWithHoarePartition();
        obj.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
