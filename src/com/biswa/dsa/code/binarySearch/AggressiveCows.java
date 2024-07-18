package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/magnetic-force-between-two-balls/description/
public class AggressiveCows {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high = position[n-1] - position[0];

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (isArrangementPossible(position, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public boolean isArrangementPossible(int[] pos, int minSeparation, int m) {
        int cnt = 1;
        int last = 0;
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - pos[last] >= minSeparation) {
                cnt++;
                last = i;
                if (cnt >= m) return true;
            }
        }

        return false;
    }


}
