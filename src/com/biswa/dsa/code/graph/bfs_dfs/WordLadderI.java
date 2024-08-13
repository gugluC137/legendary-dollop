package com.biswa.dsa.code.graph.bfs_dfs;

import java.util.ArrayDeque;
import java.util.List;

//https://leetcode.com/problems/word-ladder/description/
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] vis = new boolean[wordList.size()];
        int beginIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (beginWord.equals(wordList.get(i))) beginIdx = i;
            if (endWord.equals(wordList.get(i))) endIdx = i;
        }

        if (endIdx == -1) return 0;

        if (beginIdx != -1) vis[beginIdx] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(beginIdx);

        boolean reached = false;
        int c = 0;

        while (!q.isEmpty() && !reached) {
            int s = q.size();
            c++;
            for (int i = 0; i < s; i++) {
                int idx = q.poll();
                String word = idx == -1 ? beginWord : wordList.get(idx);

                if (idx == endIdx) {
                    reached = true;
                    break;
                }

                for (int j = 0; j < wordList.size(); j++) {
                    if (!vis[j] && isOneStepAway(word, wordList.get(j))) {
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }
        }

        return reached ? c : 0;
    }

    public boolean isOneStepAway(String begin, String candidate) {
        int c = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == candidate.charAt(i)) c++;
        }

        return c == begin.length()-1;
    }
}
