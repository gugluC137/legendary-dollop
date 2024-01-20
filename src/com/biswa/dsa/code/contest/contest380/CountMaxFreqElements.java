package com.biswa.dsa.code.contest.contest380;

import java.util.Arrays;

public class CountMaxFreqElements {
    public int maxFrequencyElements(int[] nums) {
        int[] freqs = new int[101];
        Arrays.fill(freqs, 0);

        int maxFreq = 0;

        for (int num : nums) {
            freqs[num]++;
            if (maxFreq < freqs[num]) maxFreq = freqs[num];
        }

        int maxFreqElem = 0;
        for (int freq : freqs) {
            if (freq == maxFreq) maxFreqElem += maxFreq;
        }

        return maxFreqElem;
    }
}
