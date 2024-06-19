package com.biswa.dsa.code.random;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollideAsteroids {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> nAsteroids = new ArrayList<>();
        ArrayDeque<Integer> pAsteroids = new ArrayDeque<>();

        for (int cur : asteroids) {
            if (cur > 0) {
                pAsteroids.push(cur);
                continue;
            }

            boolean flag = true;
            while (!pAsteroids.isEmpty()) {
                int p = pAsteroids.peek();
                if (p > Math.abs(cur)) {
                    flag = false;
                    break;
                }

                pAsteroids.pop();
                if (p == Math.abs(cur)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                nAsteroids.add(cur);
            }
        }

        return getArray(nAsteroids, pAsteroids);
    }

    private static int[] getArray(List<Integer> nAsteroids, ArrayDeque<Integer> pAsteroids) {
        int[] ans = new int[nAsteroids.size() + pAsteroids.size()];
        for (int i = 0; i < nAsteroids.size(); i++) {
            ans[i] = nAsteroids.get(i);
        }
        for (int i = ans.length - 1; !pAsteroids.isEmpty(); i--) {
            ans[i] = pAsteroids.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            new CollideAsteroids().asteroidCollision(new int[]{5,10,-10})
        ));
    }
}
