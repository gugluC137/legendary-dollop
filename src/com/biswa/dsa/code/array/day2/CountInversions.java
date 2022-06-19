package com.biswa.dsa.code.array.day2;

import java.util.Arrays;

public class CountInversions {
    public static long getInversions(int[] arr, int n) {
        return countHelper(arr, 0, n);
    }

    private static int countHelper(int[] arr, int start, int end) {
        if (end - start == 1) return 0;

        int mid = (start + end) / 2;

        return
          countHelper(arr, start, mid)
            + countHelper(arr, mid, end)
            + merge(arr, start, mid, end);
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int count = 0;

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
                    count += leftLength - i;
                } else {
                    arr[index] = left[i++];
                }
            }
            index++;
        }

        return count;
    }
}
