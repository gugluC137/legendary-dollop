package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

public class MinimumDaysForBouquet {
    public boolean isPossible(int[] bloomDay, int m, int k, int days) {
        int bq = 0;
        int f = 0;
        for (int j : bloomDay) {
            if (j <= days) {
                f++;
            } else {
                bq += f / k;
                f = 0;
            }
        }
        bq += f/k;

        return bq >= m;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        //if we have m*k flowers or not
        if (bloomDay.length == 0 || (long) m * k > bloomDay.length) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
