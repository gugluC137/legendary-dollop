package com.biswa.dsa.code.interview.salesforce;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
public class PoliceAndThieves {

    int catchThievesI(char[] arr, int n, int k) {
        Set<Integer> setOfThieves = new HashSet<>();
        int caught = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T') {
                setOfThieves.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                for (int j = i-k; j <= i+k; j++) {
                    if (setOfThieves.contains(j)) {
                        caught++;
                        setOfThieves.remove(j);
                        break;
                    }
                }
            }
        }

        return caught;
    }

    int catchThievesII(char[] arr, int n, int k) {
        int caught = 0;
        int l = arr.length;

        int posP = -1, posT = -1;

        for (int i = 0; i < l; i++) {
            if (posP == -1 && arr[i] == 'P') posP = i;

            if (posT == -1 && arr[i] == 'T') posT = i;

            if (posT != -1 && posP != -1) break;
        }

        if (posT == -1 || posP == -1) return caught;

        while (posT < l && posP < l) {
            if (Math.abs(posP - posT) <= k) {
                caught++;
                posP = getNextPos(arr, posP, 'P');
                posT = getNextPos(arr, posT, 'T');
            } else {
                if (posP < posT) {
                    posP = getNextPos(arr, posP, 'P');
                } else {
                    posT = getNextPos(arr, posT, 'T');
                }
            }
        }

        return caught;
    }

    public int getNextPos(char[] arr, int fromPos, char ch) {

        for (int i = fromPos+1; i < arr.length; i++) {
            if (ch == arr[i]) return i;
        }

        return arr.length;
    }
}
