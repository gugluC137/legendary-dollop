package com.biswa.dsa.code.array.day1;

import static com.biswa.dsa.util.GenericUtils.swap;

import java.util.Arrays;

public class Sort012 {

    /*
    Variation Dutch National Flag problem
     */

    public static void sort012(int[] arr) {
        int n = arr.length;
        int[] pos = {0, 0, n-1};

        while(pos[1] <= pos[2]) {
            switch (arr[pos[1]]) {
                case 0 -> {
                    swap(arr, pos[0], pos[1]);
                    pos[0]++; pos[1]++;
                }
                case 1 -> pos[1]++;
                case 2 -> {
                    swap(arr, pos[1], pos[2]);
                    pos[2]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,1,0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

}
