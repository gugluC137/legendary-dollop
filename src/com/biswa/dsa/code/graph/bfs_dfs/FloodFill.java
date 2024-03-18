package com.biswa.dsa.code.graph.bfs_dfs;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.ArrayDeque;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];

        if (srcColor == color) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;

        ArrayDeque<Pair> s = new ArrayDeque<>();
        image[sr][sc] = color;
        s.push(new Pair(sr, sc));

        while (!s.isEmpty()) {
            Pair cur = s.pop();

            int[] delx = {-1, 1};
            int[] dely = {-1, 1};

            for (int del : delx) {
                int x = cur.x + del;
                if (x < rows && x >= 0 && image[x][cur.y] == srcColor) {
                    image[x][cur.y] = color;
                    s.push(new Pair(x, cur.y));
                }
            }

            for (int del : dely) {
                int y = cur.y + del;
                if (y < cols && y >= 0 && image[cur.x][y] == srcColor) {
                    image[cur.x][y] = color;
                    s.push(new Pair(cur.x, y));
                }
            }
        }

        return image;
    }

    public int[][] floodFillII(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];

        if (srcColor == color) {
            return image;
        }

        fill(image, sr, sc, color, srcColor);
        return image;
    }

    public void fill(int[][] image, int x, int y, int color, int srcColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
            return;
        }

        if (image[x][y] == srcColor) {
            image[x][y] = color;

            fill(image, x-1, y, color, srcColor);
            fill(image, x+1, y, color, srcColor);
            fill(image, x, y-1, color, srcColor);
            fill(image, x, y+1, color, srcColor);
        }
    }

}
