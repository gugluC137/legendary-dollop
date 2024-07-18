package com.biswa.dsa.code.binarySearch;

public class KthMissingPositive {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            int missingNumbers = arr[mid] - (mid+1);
            if (missingNumbers < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
        // ans = arr[high] + more = arr[high] + (k - missing)
        // = arr[high] + (k - (arr[high] - (high + 1))
        // = arr[high] + k - arr[high] + high + 1
        // k + high + 1, since low will always end up at high + 1
    }
}
