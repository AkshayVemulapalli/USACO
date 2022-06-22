//package com.company.practice.prefixSums;


import java.io.*;
import java.util.*;

public class MyCowAteMyHomework {
    static int n;
    static int[] arr;
    static double[] means;
    static double cmin = 10001;
    static double csum = 0;
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("homework");
        n = io.nextInt();
        arr = new int[n];
        means = new double[n];
        for(int i=n-1;i>=0;i--){
            arr[i] = io.nextInt();
        }
        double maxmean = 0;
        for(int i=0;i<n;i++){
            csum+=arr[i];
            cmin = Math.min(arr[i],cmin);
            means[i] = (double)((csum-cmin)/(Math.max(i,1)));
            maxmean = Math.max(maxmean, means[i]);
        }
        ArrayList<Integer> idxs = new ArrayList<>();
        for(int i=n-2;i>=0;i--){
            if(maxmean==means[i]){
                io.println(n-1-i);
            }
        }
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
        public Kattio(String problemName) throws IOException {
            super(problemName+".out");
            r = new BufferedReader(new FileReader(problemName+".in"));
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
