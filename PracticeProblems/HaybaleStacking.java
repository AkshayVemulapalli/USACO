package com.company.practice.prefixSums;


import java.io.*;
import java.util.StringTokenizer;

public class HaybaleStacking {
    static int[] countingSort(int[] input, int k) {
        int counter[] = new int[k+1]; // fill buckets
        for (int i : input) {
            counter[i]++;
        }
        int dex = 0;
        for(int i=0;i<counter.length;i++){
            while(counter[i]>0){
                input[dex++] = i;
                counter[i]--;
            }
        }
        return input;
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int k = io.nextInt();
        int[] arr = new int[n+1];
        for(int i=0;i<k;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            arr[a-1]++;
            arr[b]--;
        }
        int[] p = new int[n+2];
        for(int i=1;i<n+2;i++){
            p[i] = p[i-1] + arr[i-1];
        }
        countingSort(p, 2500);
        io.println(p[(n+1)/2]);
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() {this(System.in, System.out);}
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
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
