package com.company.practice.graphProblems;

import java.io.*;
import java.util.*;

public class Subordinates {
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] subs;
    static int dfs(int node){
        int sum = 0;
        for(int nect:adj[node]){
            sum++;
            sum+=dfs(nect);
        }
        subs[node] = sum;
        return sum;
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        adj = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=2;i<n+1;i++){
            adj[io.nextInt()].add(i);
        }
        subs = new int[n+1];
        dfs(1);
        for(int i=1;i<n+1;i++){
            io.print(subs[i]+" ");
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
