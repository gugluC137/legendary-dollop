package com.biswa.dsa.util;

import java.util.List;

public class GenericUtils {

    public static void swap(List<Integer> list, int pos1, int pos2) {
        int temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
    public static void swap(int[] list, int pos1, int pos2) {
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
    }

    /**
     * sort an array which just has the first element out of place
     *
     * @param arr array to be sorted
     * @param start index from which sorting to be done
     * @param end index until which sorting to be done
     */
    public static void sortAlmostSorted(int[] arr, int start, int end) {
        for (int i = start; i < end-1 && arr[i] > arr[i+1]; i++) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    public static int sumOfArray(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static long getCurrentTimeInMillis() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTimeInMillis());
    }
}
