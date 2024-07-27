package com.biswa.dsa.code.binarySearch;

import java.util.Arrays;

public class ProductDistribution {
    public int minimizedMaximum(int n, int[] quantities) {
        if (quantities.length == 0) return 0;

        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (allProductsDistributed(n, quantities, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public boolean allProductsDistributed(int n, int[] quantities, int max) {
        int s = 0;
        int p = 0;

        int c = quantities[0];
        while (s < n && p < quantities.length) {
            if (c <= 0) c = quantities[p];
            c -= max;
            s++;
            if (c <= 0) p++;
        }

        return p == quantities.length;
    }

    public static void main(String[] args) {
        System.out.println(new ProductDistribution().minimizedMaximum(1, new int[]{10000}));
    }
}
