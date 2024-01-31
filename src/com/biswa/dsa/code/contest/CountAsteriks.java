package com.biswa.dsa.code.contest;

public class CountAsteriks {

    /*
    d*|abc*|e*|*  3
     */
    public int countAsterisks(String s) {
        int count = 0, segmentCount = 0;

        boolean flag = false;
        for (char ch: s.toCharArray()) {
            if (ch == '|') {
                flag = !flag;
                if (flag) {
                    count += segmentCount;
                }
                segmentCount = 0;
            }

            if (ch == '*') segmentCount++;
        }
        count += segmentCount;

        return count;
    }

}
