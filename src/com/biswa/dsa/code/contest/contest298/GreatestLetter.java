package com.biswa.dsa.code.contest.contest298;

/*
Given a string of English letters s,
return the greatest English letter which occurs as both a lowercase and uppercase letter in s.
The returned letter should be in uppercase. If no such letter exists, return an empty string.
 */
public class GreatestLetter {

    public String greatestLetter(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper[ch-65]++;
            } else {
                lower[ch-97]++;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (lower[i] > 0 && upper[i] > 0) {
                char c = (char) (i + 65);
                return String.valueOf(c);
            }
        }

        return "";
    }

}
