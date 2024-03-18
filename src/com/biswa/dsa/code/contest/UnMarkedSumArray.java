package com.biswa.dsa.code.contest;

import com.biswa.dsa.util.model.ArrayElement;

import java.util.*;

public class UnMarkedSumArray {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {

        int[] arr = Arrays.copyOf(nums, nums.length);

        long sum = 0;
        PriorityQueue<ArrayElement> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.value != o2.value) {
                return o1.value - o2.value;
            }

            return o1.idx - o2.idx;
        });

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pq.offer(new ArrayElement(nums[i], i));
        }

        long[] ans = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idxToMark = queries[i][0];
            int k = queries[i][1];

            if (arr[idxToMark] != -1) {
                sum -= arr[idxToMark];
                arr[idxToMark] = -1;
            }

            while (!pq.isEmpty() && k > 0) {
                ArrayElement n = pq.poll();
                if (nums[n.idx] != -1) {
                    sum -= n.value;
                    k--;
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,2,3,1};
        int[][] q = {{1,2},{3,3},{4,2}};

        System.out.println(Arrays.toString(new UnMarkedSumArray().unmarkedSumArray(nums, q)));
    }
}
