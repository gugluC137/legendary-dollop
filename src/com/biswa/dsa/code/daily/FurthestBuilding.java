package com.biswa.dsa.code.daily;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/furthest-building-you-can-reach
public class FurthestBuilding {

    //---------------- DP solutions ------------------------------------------------------------------------------------
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //return helper(heights, bricks, ladders, 0);

        int[][][] dp = new int[heights.length][ladders+1][bricks+1];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j <= ladders; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helperMemo(heights, bricks, ladders, 0, dp);
    }

    public int helper(int[] heights, int bricks, int ladders, int noOfBuilding) {

        //base cases
        if (noOfBuilding == heights.length - 1) {
            return noOfBuilding;
        }

        //process
        if (heights[noOfBuilding] >= heights[noOfBuilding+1]) {
            return helper(heights, bricks, ladders, noOfBuilding+1);
        }

        if (bricks == 0 && ladders == 0) {
            return noOfBuilding;
        }

        int withBricks = noOfBuilding;
        int noOfBricksRequired = heights[noOfBuilding+1] - heights[noOfBuilding];
        if (noOfBricksRequired <= bricks) {
            withBricks = helper(heights, bricks - noOfBricksRequired, ladders, noOfBuilding+1);
        }

        int withLadder = noOfBuilding;
        if (ladders > 0) {
            withLadder = helper(heights, bricks, ladders-1, noOfBuilding+1);
        }

        return Math.max(withLadder, withBricks);
    }

    public int helperMemo(int[] heights, int bricks, int ladders, int noOfBuilding, int[][][] dp) {
        //base cases
        if (noOfBuilding == heights.length - 1) {
            return noOfBuilding;
        }

        if (dp[noOfBuilding][ladders][bricks] != -1) {
            return dp[noOfBuilding][ladders][bricks];
        }

        //process
        if (heights[noOfBuilding] >= heights[noOfBuilding+1]) {
            return dp[noOfBuilding][ladders][bricks] = helper(heights, bricks, ladders, noOfBuilding+1);
        }

        if (bricks == 0 && ladders == 0) {
            return dp[noOfBuilding][ladders][bricks] = noOfBuilding;
        }

        int withBricks = noOfBuilding;
        int noOfBricksRequired = heights[noOfBuilding+1] - heights[noOfBuilding];
        if (noOfBricksRequired <= bricks) {
            withBricks = helper(heights, bricks - noOfBricksRequired, ladders, noOfBuilding+1);
        }

        int withLadder = noOfBuilding;
        if (ladders > 0) {
            withLadder = helper(heights, bricks, ladders-1, noOfBuilding+1);
        }

        return dp[noOfBuilding][ladders][bricks] = Math.max(withLadder, withBricks);
    }

    public int helperTab(int[] heights, int bricks, int ladders) {
        //return helper(heights, bricks, ladders, 0);

        int[][][] dp = new int[heights.length][ladders+1][bricks+1];
        //base case: all values at last 2d matrix is heights.length - 1;
        for (int i = 0; i <= ladders; i++) {
            Arrays.fill(dp[heights.length - 1][i], heights.length-1);
        }

        //process
        for (int i = heights.length-2; i >= 0; i--) {
            for (int j = ladders; j >= 0; j--) {
                for (int k = bricks; k >= 0; k--) {
                    //case 1: when height of current building is greater than or equal to next building
                    if (heights[i] >= heights[i+1]) {
                        dp[i][j][k] = dp[i+1][j][k];
                        continue;
                    }

                    //case 2: when we don't have any more bricks/ladders
                    //(as per above condition, height of next building is greater than current one)
                    if (j == 0 && k == 0) {
                        dp[i][j][k] = i;
                        continue;
                    }

                    //case 3: will try once with bricks and once with ladder
                    int withBricks = i;
                    int noOfBricksRequired = heights[i+1] - heights[i];
                    if (noOfBricksRequired <= k) {
                        withBricks = dp[i+1][j][k-noOfBricksRequired];
                    }

                    int withLadder = i;
                    if (j > 0) {
                        withLadder = dp[i+1][j-1][k];
                    }

                    dp[i][j][k] = Math.max(withLadder, withBricks);
                }
            }
        }

        return dp[0][ladders][bricks];
    }

    public int helperSO(int[] heights, int bricks, int ladders) {

        int[][] prev = new int[ladders+1][bricks+1];

        //base case: all values at last 2d matrix is heights.length - 1;
        for (int i = 0; i <= ladders; i++) {
            Arrays.fill(prev[i], heights.length-1);
        }

        for (int i = heights.length-2; i >= 0; i--) {

            int[][] cur = new int[ladders+1][bricks+1];
            for (int j = ladders; j >= 0; j--) {
                for (int k = bricks; k >= 0; k--) {
                    //case 1: when height of current building is greater than or equal to next building
                    if (heights[i] >= heights[i+1]) {
                        cur[j][k] = prev[j][k];
                        continue;
                    }

                    //case 2: when we don't have any more bricks/ladders
                    //(as per above condition, height of next building is greater than current one)
                    if (j == 0 && k == 0) {
                        cur[j][k] = i;
                        continue;
                    }

                    //case 3: will try once with bricks and once with ladder
                    int withBricks = i;
                    int noOfBricksRequired = heights[i+1] - heights[i];
                    if (noOfBricksRequired <= k) {
                        withBricks = prev[j][k-noOfBricksRequired];
                    }

                    int withLadder = i;
                    if (j > 0) {
                        withLadder = prev[j-1][k];
                    }

                    cur[j][k] = Math.max(withLadder, withBricks);
                }
            }

            prev = cur;
        }

        return prev[ladders][bricks];
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Greedy solution -------------------------------------------------------------------------------------------------


    public int furthestBuildingGreedy(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> heightsForLadderUse = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];

            if (diff <= 0) {
                continue;
            }

            heightsForLadderUse.add(diff);

            if (!heightsForLadderUse.isEmpty() && heightsForLadderUse.size() > ladders) {
                bricks -= heightsForLadderUse.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }

    public static void main(String[] args) {
        int[] h = {4,12,2,7,3,18,20,3,19};
        System.out.println(new FurthestBuilding().furthestBuildingGreedy(h, 10, 2));
    }

}
