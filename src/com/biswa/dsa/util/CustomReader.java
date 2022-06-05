package com.biswa.dsa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CustomReader {

    static BufferedReader br;
    static StringTokenizer st;

    public static void init(final InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        st = new StringTokenizer("");
    }

    public static void init() {
        init(System.in);
    }

    public static void close() throws IOException {
        br.close();
        st = new StringTokenizer("");
    }

    public static String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static char nextChar() throws IOException {
        return next().charAt(0);
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
