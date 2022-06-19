package com.biswa.dsa.util.sort.impl;

import com.biswa.dsa.util.sort.SortArray;
import java.util.Arrays;

public class MergeSort implements SortArray {

    @Override
    public void sort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length);
    }

    private void mergeSortHelper(int[] arr, int start, int end) {
        if (end - start == 1) return;

        int mid = (start + end) / 2;
        mergeSortHelper(arr, start, mid);
        mergeSortHelper(arr, mid, end);

        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        //left : [start, mid)
        //right : [mid, end)

        int[] left = Arrays.copyOfRange(arr, start, mid);
        int[] right = Arrays.copyOfRange(arr, mid, end);

        int index = start;
        int i = 0, j = 0;
        int leftLength = left.length;
        int rightLength = right.length;

        while(index < end) {
            if (i == leftLength) {
                arr[index] = right[j++];
            } else if (j == rightLength) {
                arr[index] = left[i++];
            } else {
                if (left[i] > right[j]) {
                    arr[index] = right[j++];
                } else {
                    arr[index] = left[i++];
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {213,3,44,235,5,5,3636,6,36,5,6546,35,232,3,5,35,4};

        MergeSort obj = new MergeSort();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
