package com.biswa.dsa.code.random;

import com.biswa.dsa.util.CustomReader;

import java.io.IOException;

//https://codeforces.com/problemset/problem/1948/A
public class SpecialCharacters {
    public String solution(int n) {
        if (n%2 == 1) return "NO";

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= n/2; i++) {
            if (i%2 == 0) {
                ans.append("AA");
            } else {
                ans.append("BB");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        CustomReader.init();

        int t = CustomReader.nextInt();
        while (t-- > 0) {

        }

    }
}
