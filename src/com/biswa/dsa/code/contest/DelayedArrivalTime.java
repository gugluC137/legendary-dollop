package com.biswa.dsa.code.contest;

public class DelayedArrivalTime {
    public int solution(int arrivalTime, int delayedTime) {

        return (arrivalTime + delayedTime) % 24;
    }
}
