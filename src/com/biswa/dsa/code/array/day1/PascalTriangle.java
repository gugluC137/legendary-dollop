package com.biswa.dsa.code.array.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

  private static final long LONG_ONE = 1L;

  public static List<List<Long>> getPascal(int n) {

    List<List<Long>> result = new ArrayList<>();

    if(n >= 1) {
      List<Long> firstRow = Collections.singletonList(LONG_ONE);
      result.add(firstRow);
    }

    for (int row = 1; row < n; row++) {
      List<Long> prevRow = result.get(row-1);
      List<Long> curRow = new ArrayList<>();

      curRow.add(LONG_ONE);
      for (int col = 1; col < row; col++) {
        long value = prevRow.get(col-1) + prevRow.get(col);
        curRow.add(value);
      }
      curRow.add(LONG_ONE);

      result.add(curRow);
    }

    return result;
  }

  public static void main(String[] args) {
    List<List<Long>> pascal = getPascal(40);
    for(List<Long> row : pascal) {
      System.out.println(row);
    }
  }

}
