package com.biswa.dsa.code.random;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortedKey = new String(chars);
            if (!mp.containsKey(sortedKey)) {
                mp.put(sortedKey, new ArrayList<>());
            }

            mp.get(sortedKey).add(str);
        }

        mp.forEach((k, v) -> {
            ans.add(v);
        });

        return ans;
    }
}
