package com.biswa.dsa.code.graph;

import java.util.Arrays;

public class WordSearchI {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && helper(board, word, 0, i, j, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int idx, int x, int y, boolean[][] vis) {
        if (idx == word.length()) return true;

        if (x < 0 || y < 0 || x == board.length || y == board[0].length) return false;

        vis[x][y] = true;
        if (helper(board, word, idx+1, x, y-1, vis) ||
            helper(board, word, idx+1, x-1, y, vis) ||
            helper(board, word, idx+1, x, y+1, vis) ||
            helper(board, word, idx+1, x+1, y, vis)) {
            return true;
        }
        vis[x][y] = false;

        return false;
    }
}
