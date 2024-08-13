package com.biswa.dsa.code.contest;

public class RearrangeBinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0, seconds = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
            if (s.charAt(i) == '1' && zeros > 0) {
                seconds = Math.max(seconds + 1, zeros);
            }
        }
        return seconds;
    }
}
