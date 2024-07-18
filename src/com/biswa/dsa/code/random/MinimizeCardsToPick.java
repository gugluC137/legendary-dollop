package com.biswa.dsa.code.random;

import java.util.ArrayDeque;
import java.util.HashSet;

public class MinimizeCardsToPick {
    //TC : O(NlogN)
    //SC : O(N)
    public int minimumCardPickup(int[] cards) {
        var low = 2;
        var high = cards.length;

        while (low <= high) {
            var mid = low + (high-low)/2;

            if (isPossible(cards, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public boolean isPossible(int[] cards, int window) {
        var set = new HashSet<Integer>();

        for (int i = 0; i < window; i++) {
            if (set.contains(cards[i])) {
                return true;
            }
            set.add(cards[i]);
        }

        for (int i = window; i < cards.length; i++) {
            set.remove(cards[i-window]);
            if (set.contains(cards[i])) {
                return true;
            }
            set.add(cards[i]);
        }

        return false;
    }

    //TC: O(N)
    //SC: O(2N)
    public int minimumCardPickupI(int[] cards) {
        var q = new ArrayDeque<Integer>();
        var set = new HashSet<Integer>();
        int ans = cards.length+1;

        for (int v : cards) {
            if (set.contains(v)) {
                while (!q.isEmpty() && q.peek() != v) {
                    var r = q.poll();
                    set.remove(r);
                }

                ans = Math.min(ans, q.size()+1);
                q.poll(); q.offer(v);
            } else {
                q.offer(v);
                set.add(v);
            }
        }

        return ans == cards.length+1 ? -1 : ans;
    }

    public static void main(String[] args) {
        var arr = new int[]{70,37,70,41,1,62,71,49,38,50,29,76,29,41,22,66,88,18,85,53};
        System.out.println(new MinimizeCardsToPick().minimumCardPickupI(arr));
    }
}
