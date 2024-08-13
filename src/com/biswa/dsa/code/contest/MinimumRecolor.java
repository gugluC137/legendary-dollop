package com.biswa.dsa.code.contest;

public class MinimumRecolor {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') count++;
        }

        int ans = count;
        for (int i = k; i < n; i++) {
            char r = blocks.charAt(i-k);
            if (r == 'W') count--;

            char a = blocks.charAt(i);
            if (a == 'W') count++;

            ans = Math.min(ans, count);
        }

        return ans;
    }
}
