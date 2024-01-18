package com.biswa.dsa.code.atlassian;

// https://leetcode.com/problems/rank-teams-by-votes/

import java.util.*;

public class RankTeams {
    public String rankTeams(String[] votes) {

        if (votes == null || votes.length == 0) return "";

        Map<Character, int[]> teams = new HashMap<>();

        int noOfVoters = votes.length;
        int noOfTeams = votes[0].length();

        for (String str : votes) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (teams.containsKey(ch)) {
                    teams.get(ch)[i]++;
                } else {
                    int[] arr = new int[noOfTeams];
                    Arrays.fill(arr, 0);
                    arr[i]++;
                    teams.put(ch, arr);
                }
            }
        }

        // sort it, and create the rank list
        List<Map.Entry<Character, int[]>> listOfTeams = new ArrayList<>(teams.entrySet());
        listOfTeams.sort(new RankByVotes());

        //generate string
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, int[]> entry : listOfTeams) {
            ans.append(entry.getKey());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] votes1 = {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes2 = {"WXYZ","XYZW"};
        String[] votes3 = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(new RankTeams().rankTeams(votes3));
    }
}

class RankByVotes implements Comparator<Map.Entry<Character, int[]>> {
    @Override
    public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {
        int[] arr1 = o1.getValue();
        int[] arr2 = o2.getValue();
        int size = arr1.length;
        for (int i = 0; i < size; i++) {
            if (arr1[i] != arr2[i]) return arr2[i] - arr1[i];
        }

        char ch1 = o1.getKey();
        char ch2 = o2.getKey();
        return ch1 - ch2;

    }
}
