package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class FencePlanning {
    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int[] x, y;
    static int maxx = 0;
    static int maxy = 0;
    static int minx = 1000000000;
    static int miny = 1000000000;
    static int perim = 1000000000;
    static void dfs(int node){
        visited[node] = true;
        maxx = Math.max(x[node],maxx);
        maxy = Math.max(y[node],maxy);
        minx = Math.min(x[node],minx);
        miny = Math.min(y[node],miny);
        for(int nect: adj[node]){
            if(!visited[nect]) {
                dfs(nect);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("fenceplan");
        n = io.nextInt();
        m = io.nextInt();
        visited = new boolean[n];
        adj = new ArrayList[n];
        x = new int[n];
        y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = io.nextInt();
            y[i] = io.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                maxx = 0;
                maxy = 0;
                minx = 1000000000;
                miny = 1000000000;
                dfs(i);
            }
            perim = Math.min(perim, 2*(maxx-minx)+2*(maxy-miny));
        }
        io.println(perim);
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
