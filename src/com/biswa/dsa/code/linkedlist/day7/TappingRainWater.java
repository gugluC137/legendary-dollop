package com.biswa.dsa.code.linkedlist.day7;

public class TappingRainWater {

  public int trap(int[] height) {
    int[] left = new int[height.length];
    int[] right = new int[height.length];

    int max = 0;
    for (int i = 0; i < height.length; i++) {
      if (max < height[i]) max = height[i];
      left[i] = max;
    }
    max = 0;
    for (int i = height.length-1; i >= 0; i--) {
      if (max < height[i]) max = height[i];
      right[i] = max;
    }

    int trappedVol = 0;
    for (int i = 0; i < height.length; i++) {
      trappedVol += Math.min(right[i], left[i]) - height[i];
    }

    return trappedVol;
  }

  public static void main(String[] args) {
    int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(new TappingRainWater().trap(arr));
  }

}
