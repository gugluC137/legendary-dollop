package com.biswa.dsa.code.random;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {

            if (pq.size() >= k) {
                if (!pq.isEmpty() && pq.peek() < n) {
                    pq.poll();
                } else {
                    continue;
                }
            }

            pq.offer(n);
        }

        return pq.peek();
    }
}
