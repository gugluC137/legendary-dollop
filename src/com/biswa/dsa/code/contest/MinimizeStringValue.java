package com.biswa.dsa.code.contest;

import java.util.*;

//https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value/
public class MinimizeStringValue {
    public String minimizeStringValue(String s) {
        int[] fr = new int[26];
        Arrays.fill(fr, 0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') continue;
            fr[s.charAt(i) - 'a']++;
        }

        int[] rpl = new int[26];
        Arrays.fill(rpl, 0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int minIdx = 0;
                for (int j = 1; j < 26; j++) {
                    if (fr[minIdx] > fr[j]) {
                        minIdx = j;
                    }
                }
                rpl[minIdx]++;
                fr[minIdx]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        int rplIdx = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                while (rpl[rplIdx] == 0) rplIdx++;
                char c = (char) ('a' + rplIdx);
                ans.append(c);
                rpl[rplIdx]--;
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxy??";
        System.out.println(new MinimizeStringValue().minimizeStringValue(s));
    }
}
