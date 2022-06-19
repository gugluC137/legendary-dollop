package com.biswa.dsa.code.array.day2;

import java.util.ArrayList;

public class RepeatAndMissingNumber {

    public int[] repeatedNumber(ArrayList<Integer> A) {
        long N = A.size();
        long S = N*(N+1)/2;
        long P = N*(N+1)*(2*N+1)/6;

        for (long value: A) {
            S -= value;
            P -= value*value;
        }

        int missing = (int) (S + P/S)/2;
        int repeating = missing - (int)S;

        return new int[]{missing, repeating};
    }

}
