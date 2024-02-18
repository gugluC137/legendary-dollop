package com.biswa.dsa.code.random;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        helper(s, 0, 1, ans);
        return ans.toString();
    }

    public int helper(String str, int idx, int count, StringBuilder ans) {
        StringBuilder thread = new StringBuilder();
        StringBuilder currCount = new StringBuilder();
        int i;

        for (i = idx; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                thread.append(ch);
            } else if (Character.isDigit(ch)) {
                currCount.append(ch);
            } else if (ch == '[') {
                i = helper(str, i+1, Integer.parseInt(currCount.toString()), thread);
                currCount = new StringBuilder();
            } else if (ch == ']') {
                break;
            }
        }

        for (int j = 1; j <= count; j++) {
            ans.append(thread);
        }
        return i;
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        DecodeString obj = new DecodeString();

        System.out.println(obj.decodeString(s1));
        System.out.println(obj.decodeString(s2));
        System.out.println(obj.decodeString(s3));
    }
}
