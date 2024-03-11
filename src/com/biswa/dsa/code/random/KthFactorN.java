package com.biswa.dsa.code.random;

import java.util.ArrayDeque;

public class KthFactorN {
    public int kthFactor(int n, int k) {
        //maintain 2 lists (think about the ds later)
        //run a loop till sqrt of n
        //when a number is a factor:
        //  check if the size of the first list == k-1:
        //      return the number
        //  else
        //      add the number in list1 and add the quotient in list2

        ArrayDeque<Integer> s2 = new ArrayDeque<>();
        int sq = (int) Math.ceil(Math.sqrt(n));
        for (int i = 1; i <= sq; i++) {
            if (n % i == 0) {
                if (k == 1) {
                    return i;
                } else {
                    k--;
                    int q = n/i;
                    if (i != q) {
                        s2.push(n/i);
                    }
                }
            }
        }

        if (s2.size() < k) {
            return -1;
        }

        int ans = -1;
        for (; !s2.isEmpty() && k > 0; k--) {
            ans = s2.pop();
        }

        return ans;
    }
}
