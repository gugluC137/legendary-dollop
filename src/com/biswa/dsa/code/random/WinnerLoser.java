package com.biswa.dsa.code.random;

import java.util.*;

public class WinnerLoser {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> mapOfLoses = new HashMap<>();

        for (int[] match : matches) {
            if (!mapOfLoses.containsKey(match[0])) {
                mapOfLoses.put(match[0], 0);
            }

            if (mapOfLoses.containsKey(match[1])) {
                mapOfLoses.put(match[1], mapOfLoses.get(match[1]) + 1);
            } else {
                mapOfLoses.put(match[1], 1);
            }
        }

        List<Integer> ans0 = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();


        for (Map.Entry<Integer, Integer> team : mapOfLoses.entrySet()) {
            if (team.getValue() == 0) ans0.add(team.getKey());
            if (team.getValue() == 1) ans1.add(team.getKey());
        }

        Collections.sort(ans0); Collections.sort(ans1);

        return Arrays.asList(ans0, ans1);
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(new WinnerLoser().findWinners(matches));
    }
}
