package com.biswa.dsa.code.array.day1;

import static com.biswa.dsa.util.CustomReader.*;

import java.io.IOException;

public class MaxSubArraySum {
//Kadane's algorithm
    public static long maxSubArraySum(int[] arr) {
        int sum = 0, maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {

        init();
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        System.out.println(maxSubArraySum(arr));

    }

}
