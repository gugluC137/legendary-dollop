package com.biswa.dsa.code.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/zigzag-conversion/description/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<List<Character>> ansList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ansList.add(new ArrayList<>());
        }

        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (idx == s.length()) break;
                ansList.get(i).add(s.charAt(idx));
                idx++;
            }

            for (int i = numRows-2; i > 0; i--) {
                if (idx == s.length()) break;
                ansList.get(i).add(s.charAt(idx));
                idx++;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (char ch : ansList.get(i)) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
