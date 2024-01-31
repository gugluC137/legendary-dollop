package com.biswa.dsa.code.contest;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {

    public String decodeMessage(String key, String message) {
        StringBuilder ans = new StringBuilder();

        char alphabet = 97;
        Map<Character, Character> decipher = new HashMap<>();
        for (char ch: key.toCharArray()) {
            if (Character.isWhitespace(ch) || decipher.containsKey(ch)) continue;

            decipher.put(ch, alphabet++);
            if (alphabet > 122) break;
        }

        for (char ch: message.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                ans.append(ch);
            } else {
                ans.append(decipher.get(ch));
            }
        }

        return ans.toString();
    }

}
