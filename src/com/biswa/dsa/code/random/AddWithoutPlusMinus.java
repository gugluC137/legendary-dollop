package com.biswa.dsa.code.random;

//https://leetcode.com/problems/sum-of-two-integers/
public class AddWithoutPlusMinus {

    public static int getSum(int a, int b) {
        int s = a^b;
        int c = a&b;
        c = c<<1;

        if (c != 0) {
            s = getSum(s, c);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(getSum(-2,3));
    }

}
