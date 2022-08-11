package com.biswa.dsa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CustomReader {

    private static BufferedReader br;
    private static StringTokenizer st;
    private static final String DEFAULT_DELIMITER = " \t\n\r\f";
    private static final String COMMA_DELIMITER = " ,\t\n";
    private static final String EMPTY_STRING = "";

    public static void init(final InputStream is) {
        System.out.println("Initializing Custom Reader");
        br = new BufferedReader(new InputStreamReader(is));
        st = new StringTokenizer(EMPTY_STRING, DEFAULT_DELIMITER);
    }

    public static void init() {
        init(System.in);
    }

    public static void close() throws IOException {
        System.out.println("Closing Custom Reader");
        br.close();
        st = new StringTokenizer(EMPTY_STRING);
    }

    public static String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine(), DEFAULT_DELIMITER);
        }
        return st.nextToken();
    }

    public static char nextChar() throws IOException {
        return next().charAt(0);
    }
    public static char nextChar(String s) throws IOException {
        System.out.println(s);
        return nextChar();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static int nextInt(String s) throws IOException {
        System.out.println(s);
        return nextInt();
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    public static double nextDouble(String s) throws IOException {
        System.out.println(s);
        return nextDouble();
    }

}
