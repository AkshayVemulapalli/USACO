package com.company.practice.prefixSums;


import java.io.*;
import java.util.StringTokenizer;

public class ForestQueries {
    static int[][] psums;
    static int cti(char hi){
        if(hi=='*'){return 1;}else{return 0;}
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int q = io.nextInt();
        psums = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            String line = io.next();
            for(int j=0;j<n;j++){
                psums[i+1][j+1] = psums[i+1][j] + psums[i][j+1] - psums[i][j] + cti(line.charAt(j));
            }
        }
        for(int i=0;i<q;i++){
            int y1 = io.nextInt();
            int x1 = io.nextInt();
            int y2 = io.nextInt();
            int x2 = io.nextInt();
            io.println(psums[y2][x2]-psums[y2][x1-1]-psums[y1-1][x2]+psums[y1-1][x1-1]);
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
