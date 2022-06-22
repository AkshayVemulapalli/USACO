package com.company.practice.prefixSums;

import java.io.*;
import java.util.StringTokenizer;

public class PaintingTheBarn {
    static int n,k;
    static int[][] arr;
    static int[][] p;
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("paintbarn");
        int ans = 0;
        n = io.nextInt();
        k = io.nextInt();
        arr = new int[1001][1001];
        p = new int[1002][1002];
        for(int i=0;i<n;i++){
            int x1 = io.nextInt();
            int y1 = io.nextInt();
            int x2 = io.nextInt();
            int y2 = io.nextInt();
            arr[y1][x1]++;
            arr[y2][x1]--;
            arr[y1][x2]--;
            arr[y2][x2]++;
        }
        for(int i=1;i<1002;i++){
            for(int j=1;j<1002;j++){
                p[i][j] = arr[i-1][j-1] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
                if(p[i][j]==k){ans++;}
            }
        }
        io.println(ans);
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
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
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
