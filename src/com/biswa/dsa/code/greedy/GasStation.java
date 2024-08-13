package com.biswa.dsa.code.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, total = 0, pos = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];

            if (curSum < 0) {
                total += curSum;
                curSum = 0;
                pos = i+1;
            }
        }
        total += curSum;

        return total < 0 ? -1 : pos;
    }
}
