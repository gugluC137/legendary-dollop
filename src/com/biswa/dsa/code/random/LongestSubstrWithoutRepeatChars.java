package com.biswa.dsa.code.random;

import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstrWithoutRepeatChars {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();

        int lead = 0, trail = 0;
        while (lead < l) {
            char ch = s.charAt(lead);

            if (chars.contains(ch)) {
                while (s.charAt(trail) != ch) {
                    chars.remove(s.charAt(trail));
                    trail++;
                }
                trail++;
            } else {
                chars.add(ch);
            }

            int curLength = lead - trail + 1;
            if (curLength > maxLength) {
                maxLength = curLength;
            }

            lead++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstrWithoutRepeatChars obj = new LongestSubstrWithoutRepeatChars();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

}
