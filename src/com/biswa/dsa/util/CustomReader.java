package com.biswa.dsa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CustomReader {

  static BufferedReader br;
  static StringTokenizer st;

  static void init(final InputStream is) {
    br = new BufferedReader(new InputStreamReader(is));
    st = new StringTokenizer("");
  }

  static void init() {
    init(System.in);
  }

  static void close() throws IOException {
    br.close();
    st = new StringTokenizer("");
  }

  static String next() throws IOException {
    while (!st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }
    return st.nextToken();
  }

  static char nextChar() throws IOException {
    return next().charAt(0);
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

}
