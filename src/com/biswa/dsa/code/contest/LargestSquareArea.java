package com.biswa.dsa.code.contest;

//https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/
public class LargestSquareArea {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int noOfRect = bottomLeft.length;
        long maxSide = 0;
        for (int i = 0; i < noOfRect; i++) {
            for (int j = i+1; j < noOfRect; j++) {
                int side = getLargestSquareInIntersection(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                maxSide = Math.max(maxSide, side);
            }
        }

        return maxSide * maxSide;
    }

    public int getLargestSquareInIntersection(int[] bottomRect1, int[] topRect1, int[] bottomRect2, int[] topRect2) {

        if (bottomRect1[1] >= topRect2[1] || bottomRect2[1] >= topRect1[1]) {
            return 0;
        }

        if (bottomRect1[0] >= topRect2[0] || bottomRect2[0] >= topRect1[0]) {
            return 0;
        }

        int bx = Math.max(bottomRect1[0], bottomRect2[0]);
        int by = Math.max(bottomRect1[1], bottomRect2[1]);
        int tx = Math.min(topRect1[0], topRect2[0]);
        int ty = Math.min(topRect1[1], topRect2[1]);

        return Math.min(tx-bx, ty-by);
    }


}
