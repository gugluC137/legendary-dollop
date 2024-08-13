package com.biswa.dsa.code.string;

public class MaximizeNumber {

    public String removeDigit(String number, char digit) {

        StringBuilder num = new StringBuilder(number);
        int pos = -1;

        for(int i = 0; i < num.length()-1; i++) {
            //
            if(number.charAt(i) == digit && number.charAt(i+1) > number.charAt(i)) {
                pos = i; break;
            }
        }

        if (pos == -1) {
            pos = number.lastIndexOf(digit);
        }

        return num.deleteCharAt(pos).toString();
    }

    public static void main(String[] args) {
        String s1 = "1231";
        String s2 = "9131";
        String s3 = "133235";

        MaximizeNumber obj = new MaximizeNumber();
        System.out.println(obj.removeDigit(s1, '1'));
        System.out.println(obj.removeDigit(s2, '1'));
        System.out.println(obj.removeDigit(s3, '3'));
    }

}
