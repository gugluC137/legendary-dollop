package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

public class FlowerBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int f = flowers.length;
        var start = new int[f];
        var end = new int[f];

        var i = 0;
        for (var b : flowers) {
            start[i] = b[0];
            end[i] = b[1];
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        var ans = new int[people.length];
        i = 0;
        for (var p : people) {
            int s = upperBound(start, p);
            int e = lowerBound(end, p);
            ans[i++] = s-e;
        }

        return ans;
    }

    public int lowerBound(int[] arr, int target) {
        int l = 0, h = arr.length;

        while (l <= h) {
            var mid = l + (h-l)/2;
            if (arr[mid] >= target) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        return l;
    }

    public int upperBound(int[] arr, int target) {
        int l = 0, h = arr.length;

        while (l <= h) {
            var mid = l + (h-l)/2;
            if (arr[mid] > target) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        return l;
    }
}
