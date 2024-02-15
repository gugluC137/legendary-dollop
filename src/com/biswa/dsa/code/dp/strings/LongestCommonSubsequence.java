package com.biswa.dsa.code.dp.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solWithMemo(text1.length()-1, text2.length()-1, text1, text2, dp);
    }

    public int solWithRecursion(int idx1, int idx2, String text1, String text2) {
        //base condition
        if (idx1 == -1 || idx2 == -1) {
            return 0;
        }

        //process
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + solWithRecursion(idx1 - 1, idx2 - 1, text1, text2);
        }

        return Math.max(
            solWithRecursion(idx1, idx2-1, text1, text2),
            solWithRecursion(idx1-1, idx2, text1, text2)
        );
    }

    public int solWithMemo(int idx1, int idx2, String text1, String text2, int[][] dp) {
        //base condition
        if (idx1 == -1 || idx2 == -1) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        //process
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + solWithMemo(idx1 - 1, idx2 - 1, text1, text2, dp);
        }

        return dp[idx1][idx2] = Math.max(
            solWithMemo(idx1, idx2-1, text1, text2, dp),
            solWithMemo(idx1-1, idx2, text1, text2, dp)
        );
    }

    public int solWithTab(String text1, String text2) {
        int size1 = text1.length(), size2 = text2.length();

        int[][] dp = new int[size1+1][size2+1];

        //base condition
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= size1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[size1][size2];
    }

    public int solWithSO(String text1, String text2) {
        int size1 = text1.length(), size2 = text2.length();

        int[] prev = new int[size2+1];

        //base condition
        Arrays.fill(prev, 0);

        for (int i = 1; i <= size1; i++) {
            int[] cur = new int[size2+1];
            for (int j = 1; j <= size2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }

        return prev[size2];
    }

    public static void main(String[] args) {
        String text1 = "abce";
        String text2 = "dabfce";

        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
        System.out.println(new LongestCommonSubsequence().solWithTab(text1, text2));
        System.out.println(new LongestCommonSubsequence().solWithSO(text1, text2));
    }
}
