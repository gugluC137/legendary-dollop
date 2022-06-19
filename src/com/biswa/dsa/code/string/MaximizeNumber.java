package com.biswa.dsa.code.string;

public class MaximizeNumber {

    public static String removeDigit(String number, char digit) {

        StringBuilder num = new StringBuilder(number);
        int pos = 0;

        for(int i = 0; i < num.length(); i++) {
            if(number.charAt(i) == digit) {
                pos = i;
                if(i != num.length()-1 &&
                  number.charAt(i+1) > number.charAt(i)) break;
            }
        }

        return num.deleteCharAt(pos).toString();
    }

    public static void main(String[] args) {

    }

}
