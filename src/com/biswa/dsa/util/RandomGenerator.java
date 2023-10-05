package com.biswa.dsa.util;

import java.util.Random;

public class RandomGenerator {
    public boolean pickOrNotPick() {
        return new Random().nextBoolean();
    }

    public static void main(String[] args) {
        int start = 21, end = 30;
        for (int i = start; i <= end; i++) {
            System.out.println(i + " : " + new RandomGenerator().pickOrNotPick());
        }
    }
}
