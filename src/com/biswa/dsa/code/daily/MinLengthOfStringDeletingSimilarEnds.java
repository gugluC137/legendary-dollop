package com.biswa.dsa.code.daily;

//https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
public class MinLengthOfStringDeletingSimilarEnds {
    public int minimumLength(String s) {

        int l = 0, r = s.length() - 1;
        while (l < r) {
            char ch = s.charAt(l);

            int i = l;
            while (i < r && s.charAt(i) == ch) {
                i++;
            }

            int j = r;
            boolean weCanDelete = false;
            while (j >= i && s.charAt(j) == ch) {
                j--;
                weCanDelete = true;
            }

            if (weCanDelete) {
                l = i;
                r = j;
            } else {
                break;
            }
        }

        return r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(new MinLengthOfStringDeletingSimilarEnds().minimumLength("abbbbbbbbbbbbbbbbbbba"));
    }
}
