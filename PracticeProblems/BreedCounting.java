package com.company.practice.prefixSums;

import java.io.*;
import java.util.*;

public class BreedCounting {
    public static int bti(boolean b) {
        return b ? 1 : 0;
    }
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("bcount");
        int n = io.nextInt();
        int q = io.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = io.nextInt();
        }
        int[] psums1 = new int[n+1];
        int[] psums2 = new int[n+1];
        int[] psums3 = new int[n+1];
        psums1[0] = 0;
        psums2[0] = 0;
        psums3[0] = 0;
        for(int i=1;i<n+1;i++){
            psums1[i] = psums1[i-1] + bti(arr[i-1]==1);
            psums2[i] = psums2[i-1] + bti(arr[i-1]==2);
            psums3[i] = psums3[i-1] + bti(arr[i-1]==3);
        }
        for(int i=0;i<q;i++){
            int lo = io.nextInt();
            int hi = io.nextInt();
            io.print(psums1[hi]-psums1[lo-1]+" ");
            io.print(psums2[hi]-psums2[lo-1]+" ");
            io.println(psums3[hi]-psums3[lo-1]);
        }
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
