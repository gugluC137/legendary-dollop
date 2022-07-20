package com.biswa.dsa.util.sort.impl;

import static com.biswa.dsa.util.GenericUtils.swap;

import com.biswa.dsa.util.sort.SortArray;

public class HeapSort implements SortArray {

    @Override
    public void sort(int[] arr) {
        heapsort(arr);
    }

    private void heapsort(int[] ar) {
        if (ar == null) return;
        int n = ar.length;

        // Heapify, converts array into binary heap O(n), see:
        // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
        for (int i = Math.max(0, (n / 2) - 1); i >= 0; i--) {
            sink(ar, n, i);
        }

        // Sorting bit
        for (int i = n - 1; i >= 0; i--) {
            swap(ar, 0, i);
            sink(ar, i, 0);
        }
    }

    private void sink(int[] ar, int n, int i) {
        while (true) {
            int left = 2 * i + 1; // Left  node
            int right = 2 * i + 2; // Right node
            int largest = i;

            // Right child is larger than parent
            if (right < n && ar[right] > ar[largest]) largest = right;

            // Left child is larger than parent
            if (left < n && ar[left] > ar[largest]) largest = left;

            // Move down the tree following the largest node
            if (largest != i) {
                swap(ar, largest, i);
                i = largest;
            } else break;
        }
    }
}
