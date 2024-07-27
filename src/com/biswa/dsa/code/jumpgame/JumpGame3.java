package com.biswa.dsa.code.jumpgame;

import java.util.Arrays;

//https://leetcode.com/problems/jump-game-iii/description/
public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        Arrays.fill(vis, false);

        return helper(arr, start, vis);
    }

    public boolean helper(int[] arr, int start, boolean[] vis) {
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;

        if (vis[start]) return false;

        vis[start] = true;

        return helper(arr, start + arr[start], vis) ||
            helper(arr, start - arr[start], vis);
    }

    public boolean canReachI(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;

        if (arr[start] == 0) return true;

        arr[start] = -arr[start];

        return canReachI(arr, start + arr[start]) ||
            canReachI(arr, start - arr[start]);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int[] arr2 = {4,2,3,0,3,1,2};
        int[] arr3 = {3,0,2,1,2};
        JumpGame3 obj = new JumpGame3();
        System.out.println(obj.canReachI(arr, 5));
        System.out.println(obj.canReachI(arr2, 0));
        System.out.println(obj.canReachI(arr3, 2));
    }
}
