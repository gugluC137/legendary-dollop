package com.biswa.dsa.code.random;

import static com.biswa.dsa.util.GenericUtils.sumOfArray;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaxCardPoints {

    public static int maxScore(int[] cardPoints, int k) {
        int l = cardPoints.length;

        if (k == l) return sumOfArray(cardPoints, 0, l);
        if (k == 1) return Math.max(cardPoints[0], cardPoints[l-1]);

        int maxPoints = 0;

        int points = 0;
        int i = 0;
        while (i < k) {
            points += cardPoints[i];
            i++;
        }
        maxPoints = points;
        i--;
        for (int j = l-1; j >= l-k ; j--, i--) {
            points -= cardPoints[i];
            points += cardPoints[j];
            if (points > maxPoints)
                maxPoints = points;
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        System.out.println(maxScore(arr, 3));
    }

}
