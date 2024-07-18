package com.biswa.dsa.code.interview.rizzle;

import java.util.Arrays;

public class MinDaysForMBouquet {

    public int minDays(int[] bloomDay, int m, int k) {
        //if we have m*k flowers or not
        if ((long) m * k > bloomDay.length) return -1;

        int low = 1;
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (helper(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean helper(int[] bloomDay, int m, int k, int days) {
        int bq = 0;
        int f = 0;
        for (int j : bloomDay) {
            if (j <= days) {
                f++;
            } else {
                f = 0;
            }

            if (f == k) {
                bq++;
                f = 0;
            }

            if (bq == m) return true;
        }

        return false;
    }
}
