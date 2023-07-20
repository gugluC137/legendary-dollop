package com.biswa.dsa.code.random;

import java.util.HashSet;
import java.util.Set;

public class SurajOT {
    int sol(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;

        int l = arr.length;
        if (n > l) return 0;

        int sum = arr[n-1];
        int i = n-1+n;
        while (i < l) {
            sum += arr[i];
            i += n;
        }

        return sum;
    }

    int sol2(int[][] barrier) {
        Set<Integer> blocked = new HashSet<>();

        for (int i = 0; i < barrier.length; i++) {
            int d = barrier[i][2];
            int from = barrier[i][0];
            int to = barrier[i][0] + d;
            for (int j = from; j <= to; j++) {
                blocked.add(j);
            }
        }

        return blocked.size();
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 16, 1,5,6,3,21};
        System.out.println(new SurajOT().sol(arr, 3));

        int[][] b = {{2,3,3}, {4,6,4}};
        System.out.println(new SurajOT().sol2(b));

    }
}
