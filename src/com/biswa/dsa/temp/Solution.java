package com.biswa.dsa.temp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> intersection(int[][] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int[] num : nums) {
            for (int i : num) {
                if (!map.containsKey(i)) {
                    map.put(i, 0);
                }

                map.put(i, map.get(i) + 1);
            }
        }

        var ans = new ArrayList<Integer>();

        map.forEach((k, v) -> {
            if (v == nums.length) {
                ans.add(k);
            }
        });

        Collections.sort(ans);

        return ans;
    }
}
