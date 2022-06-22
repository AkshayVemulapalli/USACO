package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class BuildingRoads {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static void dfs(int node){
        visited[node] = true;
        for(int nect: adj[node]){
            if (!visited[nect]) {
                dfs(nect);
            }
        }
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        int count = 0;
        adj = new ArrayList[n];
        ArrayList<Integer> points = new ArrayList<Integer>();
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(0);
        points.add(0);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
                points.add(i);
            }
        }
        io.println(count);
        for(int i=1;i<points.size();i++){
            io.println((points.get(i-1)+1)+" "+(points.get(i)+1));
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
