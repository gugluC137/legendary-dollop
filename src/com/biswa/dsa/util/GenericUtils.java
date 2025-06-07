package com.biswa.dsa.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    public int maxOf3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int minOf3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
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

    private static void experimentsWithBigDecimal() {
        BigDecimal a = BigDecimal.ZERO.setScale(3, RoundingMode.HALF_UP);

        System.out.println(a.add(BigDecimal.TEN));
    }

    public static int[] getIntArrayFromIntList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static final ZoneId DUBAI_ZONE = ZoneId.of("Asia/Dubai");
    public static final ZoneId UTC_ZONE = ZoneId.of("UTC");

    public static void testDate() {
        var dateTime = "27-01-2025 10:30:00";
        var df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(LocalDateTime.parse(dateTime, df));
        System.out.println(LocalDateTime.parse(dateTime, df).atZone(DUBAI_ZONE).toLocalDateTime());
        System.out.println(LocalDateTime.parse(dateTime, df)
            .atZone(DUBAI_ZONE)
            .withZoneSameInstant(UTC_ZONE)
            .toLocalDateTime());

    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        testDate();
    }
}
