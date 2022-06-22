package com.company.practice.prefixSums;

import java.io.*;
import java.util.*;

class PrefixSums {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = 10;
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = io.nextInt();
        }
        int[] psums = new int[n+1];
        psums[0] = 0;
        for(int i=1;i<n+1;i++){
            psums[i] = psums[i-1] + arr[i-1];
        }
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
