package com.biswa.dsa.code.interview.kaleidofin;

import java.util.Arrays;

public class NextPermutationForNum {

    //input: 123
    //output: 132

    //case2:
    //in: 51432

    //52431
    //52134
    //out: 52134

    //case3:
    //in: 54321
    //out: 12345

    //case4:
    //in: 51324
    //out: 51342

    //case5:
    //in: 00

    public int sol(int num) {
        //get number of digits
        //get all the digits in array
        //find point where arr[i] < arr[i+1]
            //swap arr[i] with smallest in arr[i+1 : n-1]
            //sort the arr[i+1 : n-1]
        //else sort the complete array

        //recreate the number

        int nd = getNoOfDigits(num);
        int[] ar = new int[nd];
        getDigits(ar, num);

        int i = nd-2;
        while (i >= 0 && ar[i] > ar[i+1]) {
            i--;
        }

        if (i == -1) {
            Arrays.sort(ar);
        } else {
            int temp = ar[i];
            ar[i] = ar[nd-1];
            ar[nd-1] = temp;

            Arrays.sort(ar, i+1, nd);
        }

        return getNum(ar);
    }

    public static void main(String[] args) {
        int num = 510042; //510204
        System.out.println(new NextPermutationForNum().sol(num));
    }

    public int getNum(int[] ar) {
        int ans = 0;
        for (int n : ar) {
            ans = ans * 10 + n;
        }

        return ans;
    }

    public int getNoOfDigits(int num) {
        int d = 0;
        while(num > 0) {
            d++;
            num /= 10;
        }

        return d;
    }

    public void getDigits(int[] ar, int num) {
        int i = ar.length-1;

        while (i >= 0) {
            int n = num%10;
            num/=10;

            ar[i] = n;
            i--;
        }
    }
}
