package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

public class KokoBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = (low + high)/2;
            long hours = getHours(piles, mid);

            if (hours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public long getHours(int[] piles, int k) {
        long sum = 0;
        for (int p : piles) {
            sum += (long) Math.ceil((double)p/k);
        }

        return sum;
    }
}
