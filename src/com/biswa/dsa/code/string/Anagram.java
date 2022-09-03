package com.biswa.dsa.code.string;

import java.util.Arrays;

public class Anagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] charFreqInS = new int[26];
    Arrays.fill(charFreqInS, 0);
    for (char ch: s.toCharArray()) {
      charFreqInS[ch-97]++;
    }

    for (char ch: t.toCharArray()) {
      charFreqInS[ch-97]--;
      if (charFreqInS[ch-97] < 0) {
        return false;
      }
    }

    for (int val: charFreqInS) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }

}
