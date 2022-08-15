package com.biswa.dsa.code.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordSeq {

    public String reverseWordsI(String s) {
        Deque<StringBuilder> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                if (!sb.isEmpty()) {
                    st.push(sb);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }
        if (!sb.isEmpty()) {
            st.push(sb);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(st.pop());
        while (!st.isEmpty()) {
            ans.append(" ").append(st.pop());
        }

        return ans.toString();
    }

    public String reverseWordsII(String s) {
        StringBuilder ans = new StringBuilder();

        int idx = 0;
        while (s.length() > idx &&
          Character.isSpaceChar(s.charAt(idx))) {
            idx++;
        }
        reverseRecursive(s, idx, ans);

        return ans.toString().trim();
    }

    public void reverseRecursive(String s, int idx, StringBuilder ans) {
        int nextSpaceIdx = s.indexOf(' ', idx);
        if (nextSpaceIdx == -1) nextSpaceIdx = s.length();
        String word = s.substring(idx, nextSpaceIdx);
        nextSpaceIdx++;
        while (s.length() > nextSpaceIdx &&
          Character.isSpaceChar(s.charAt(nextSpaceIdx))) {
            nextSpaceIdx++;
        }
        if (nextSpaceIdx >= s.length()) {
            ans.append(word).append(" ");
            return;
        }
        reverseRecursive(s, nextSpaceIdx, ans);
        ans.append(word).append(" ");
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWordSeq().reverseWordsII(s));
    }
}
