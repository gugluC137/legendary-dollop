package com.biswa.dsa.code.string;

public class CountAndSay {

  public String countAndSay(int n) {
    if (n == 1) return "1";

    String countAndSayString = countAndSay(n-1);

    StringBuilder newCountAndSayString = new StringBuilder();
    char currChar = countAndSayString.charAt(0);
    int freq = 0;
    for (char ch: countAndSayString.toCharArray()) {
      if (ch == currChar)
        freq++;
      else {
        newCountAndSayString.append(freq).append(currChar);
        currChar = ch;
        freq = 1;
      }
    }
    newCountAndSayString.append(freq).append(currChar);

    return newCountAndSayString.toString();
  }

  public static void main(String[] args) {
    System.out.println(new CountAndSay().countAndSay(10));
  }

}
