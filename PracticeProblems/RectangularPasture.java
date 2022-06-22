package com.company.practice.prefixSums;

import java.io.*;
import java.util.*;

public class RectangularPasture {
    static int n;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] xs = new int[n];
        int[] ys = new int[n];
        for(int i=0;i<n;i++){
            int x1 = io.nextInt();
            int y1 = io.nextInt();
            x[i] = x1;
            xs[i] = x1;
            y[i] = y1;
            ys[i] = y1;
        }
        Arrays.sort(xs);
        Arrays.sort(ys);
        for(int i=0;i<n;i++){
            x[i] = Arrays.binarySearch(xs, x[i]);
            y[i] = Arrays.binarySearch(ys, y[i]);
        }
        int[][] arr  = new int[n][n];
        for(int i=0;i<n;i++){
            arr[y[i]][x[i]] = 1;
        }
        long ans = n+1;
        int[][] p = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + arr[i-1][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int maxx = Math.max(x[i],x[j]);
                int maxy = Math.max(y[i],y[j]);
                int minx = Math.min(x[i],x[j]);
                int miny = Math.min(y[i],y[j]);
                int above = p[n][maxx]-p[maxy+1][maxx]-p[n][minx+1]+p[maxy+1][minx+1];
                int below = p[miny][maxx]-p[0][maxx]-p[miny][minx+1]+p[0][minx+1];
                ans+=(above+1)*(below+1);
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
