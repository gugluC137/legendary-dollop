package com.biswa.dsa.code.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class AllocateBooks {
    public int findPages(ArrayList<Integer> arr, int n, int m) {
        if (n < m) return -1;

        int low = arr.stream().reduce(arr.getFirst(), Math::max);
        int high = arr.stream().reduce(0, Integer::sum);

        while (low <= high) {
            int mid = low + (high-low)/2;
            int st = noOfStudentsShared(arr, mid);
            if (st > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public int noOfStudentsShared(List<Integer> arr, int maxPages) {
        int st = 1,  pages = 0;
        for (int p : arr) {
            if (pages+p <= maxPages) {
                pages += p;
            } else {
                st++;
                pages = p;
            }
        }

        return st;
    }
}
