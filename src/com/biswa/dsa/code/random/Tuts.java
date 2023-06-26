package com.biswa.dsa.code.random;

public class Tuts {

  public static void main(String[] args) {
    //new Tuts().printNum(1, 10);

    new Tuts().reverseStringRecursive("abcde", 0);
  }

  public void printNum(int i, int n) {
    //base condition
    if (i > n) return;

    //recursion call
    printNum(i+1, n);

    //operation
    System.out.print(i + " ");
  }

  public void reverseStringRecursive(String s, int i) {
    //base condition
    if (i == s.length()) return;

    //recursion call
    reverseStringRecursive(s, i+1);

    //operation
    char ch = s.charAt(i);
    System.out.print(ch);
  }

}
