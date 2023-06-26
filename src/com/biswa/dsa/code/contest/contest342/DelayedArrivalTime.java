package com.biswa.dsa.code.contest.contest342;

public class DelayedArrivalTime {
    public int solution(int arrivalTime, int delayedTime) {

        return (arrivalTime + delayedTime) % 24;
    }
}
