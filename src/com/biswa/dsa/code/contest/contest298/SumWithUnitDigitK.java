package com.biswa.dsa.code.contest.contest298;

/*
Given two integers num and k, consider a set of positive integers with the following properties:
The units digit of each integer is k.
The sum of the integers is num.
Return the minimum possible size of such a set, or -1 if no such set exists.
 */
public class SumWithUnitDigitK {

    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        if (k%2 == 0 && num%2 != 0) return -1;

        for (int i = 1; i <= 10; i++) {
            if (i*k <= num && (i*k)%10 == num%10) return i;
        }

        return -1;
    }

}
