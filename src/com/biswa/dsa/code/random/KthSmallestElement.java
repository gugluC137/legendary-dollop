package com.biswa.dsa.code.random;

import static com.biswa.dsa.util.GenericUtils.swap;

//todo
public class KthSmallestElement {

    public Integer selectKthElement(int[] ar, int k) {
        if (ar == null) return null;
        if (k > ar.length) return null;
        if (k < 1) return null;
        return quickSelect(ar, k, 0, ar.length - 1);
    }

    // Sort interval [lo, hi] in-place recursively, returns value when splitPoint == k - 1
    private static int quickSelect(int[] ar, int k, int lo, int hi) {
        int index = k - 1;
        if (lo < hi) {
            int splitPoint = partition(ar, lo, hi);
            if (splitPoint == index) {
                return ar[splitPoint];
            } else if (splitPoint > index) {
                return quickSelect(ar, k, lo, splitPoint);
            }
            return quickSelect(ar, k, splitPoint + 1, hi);
        }
        return ar[lo];
    }

    // Performs Hoare partition algorithm for quick select, taken from QuickSort implementation
    private static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do {
                i++;
            } while (ar[i] < pivot);
            do {
                j--;
            } while (ar[j] > pivot);
            if (i < j) swap(ar, i, j);
            else return j;
        }
    }

    public static void main(String[] args) {
        KthSmallestElement quickSelect = new KthSmallestElement();
        int[] array = {-10, 4, 6, 5, 8, -13, 10, 3};
        int kthLargestElement = quickSelect.selectKthElement(array, 1);
        System.out.println(kthLargestElement);
    }

    // -13, -10, 3, 4, 5, 6, 8, 10
    // 10, 8, 6, 5, 4, 3, -10, -13

}
