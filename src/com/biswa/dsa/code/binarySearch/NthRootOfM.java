package com.biswa.dsa.code.binarySearch;

public class NthRootOfM {

    public static double findNthRootOfM(int n, long m) {
        double h = m, l = 1;
        double eps = 1e-6;

        while (h - l > eps) {
            double mid = (h+l)/2;
            double p = multiply(mid, n, m);
            if (p > m) {h = mid;}
            else {l = mid;}
        }

        double rounding_eps = 1e6;
        return Math.round(l * rounding_eps) / rounding_eps;
    }

    private static double multiply(double base, int exp, long desiredNumber) {
        double product = 1d;
        for (int i = 0; i < exp; i++) {
            product *= base;
            if (product > desiredNumber) return product;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(findNthRootOfM(4, 69));
    }

}
