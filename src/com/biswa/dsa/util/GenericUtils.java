package com.biswa.dsa.util;

import java.util.Date;
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

  public static long getCurrentTimeInMillis() {
    return System.currentTimeMillis();
  }

  public static void main(String[] args) {
    System.out.println(getCurrentTimeInMillis());
  }
}
