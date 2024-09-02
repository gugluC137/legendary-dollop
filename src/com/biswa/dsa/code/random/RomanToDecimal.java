package com.biswa.dsa.code.random;

public class RomanToDecimal {
    public int romanToInt(String s) {
        var l = s.length();
        var prev = 0;
        var ans = 0;
        for (var i = l-1; i >= 0; i--) {
            var val = getDecimal(s.charAt(i));
            if (val >= prev) {
                ans += val;
            } else {
                ans -= val;
            }
            prev = val;
        }

        return ans;
    }

    public int getDecimal(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
