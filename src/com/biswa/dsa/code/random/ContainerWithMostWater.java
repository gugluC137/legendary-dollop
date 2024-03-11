package com.biswa.dsa.code.random;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int maxVol = 0;
        while (l < r) {
            int vol = Math.min(height[l], height[r]) * (r - l);
            maxVol = Math.max(maxVol, vol);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxVol;
    }

    public static void main(String[] args) {
        int[] h = {2,3,4,5,18,17,6};
        System.out.println(new ContainerWithMostWater().maxArea(h));

        StringBuilder s = new StringBuilder();
    }
}
