package com.biswa.dsa.code.contest;

public class TaxCollection {

    public double calculateTax(int[][] brackets, int income) {
        int unitsLeft = income;
        double taxAmount = 0.0d;

        int i = 0;
        while(i < brackets.length) {
            int upper = brackets[i][0];
            int units = i == 0 ? upper : upper - brackets[i-1][0];
            double percent = brackets[i][1];

            if (upper <= income) {
                taxAmount += units * (percent/100);
                unitsLeft -= units;
            } else {
                taxAmount += unitsLeft * (percent/100);
                break;
            }

            i++;
        }

        return taxAmount;
    }

    public static void main(String[] args) {
        int[][] arr =  {{3, 50}, {7, 10}, {12, 25}};
        TaxCollection obj = new TaxCollection();
        System.out.println(obj.calculateTax(arr, 10));
    }

}
