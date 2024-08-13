package com.biswa.dsa.code.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    //Brute force
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var mapIdx = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums2.length; i++) {
            mapIdx.put(nums2[i], i);
        }

        var ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for (var i = 0; i < nums1.length; i++) {
            var num = nums1[i];
            var idx = mapIdx.get(num);
            for (var j = idx+1; j < nums2.length; j++) {
                if (nums2[j] > num) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }

    //TC: O(nums2.length*2 + nums1.length)
    //SC: O(nums2.length*3 + nums1.length)
    public int[] nextGreaterElementOp(int[] nums1, int[] nums2) {
        var st = new Stack<Integer>();
        var mapIdx = new HashMap<Integer, Integer>();
        var ans = new int[nums1.length];
        var nge = new int[nums2.length];

        for (var i = nums2.length-1; i >= 0; i--) {
            mapIdx.put(nums2[i], i);

            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(nums2[i]);
        }

        for (var i = 0; i < nums1.length; i++) {
            ans[i] = nge[mapIdx.get(nums1[i])];
        }

        return ans;
    }

}
