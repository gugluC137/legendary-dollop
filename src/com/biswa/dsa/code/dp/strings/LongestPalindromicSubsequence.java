package com.biswa.dsa.code.dp.strings;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromicSubsequence(String text1) {
        return lcs(text1, new StringBuilder(text1).reverse().toString());
    }

    public int lcs(String s1, String s2) {
        //base case: if we get to idx -1 for any of the string, ans is 0
        //if char at i1, i2 is same, add that to the string and decrease both by 1
        //else check by decreasing i1 and i2 one at a time, and take the max of them

        int[] prev = new int[s2.length()+1];
        Arrays.fill(prev, 0);

        for (int i = 1; i <= s1.length(); i++) {
            int[] cur = new int[s2.length()+1];
            cur[0] = 0;
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }

        return prev[s2.length()];
    }
}
