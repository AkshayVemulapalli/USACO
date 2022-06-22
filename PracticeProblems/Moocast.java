package com.company.practice.graphProblems;

import java.io.*;
import java.util.*;

public class Moocast {
    static int n;
    static int[] radii;
    static int[] x;
    static int[] y;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean pointsindist(int x1, int y1, int x2, int y2, int dist){
        int xdist = x2-x1;
        int ydist = y2-y1;
        double pointdist = Math.sqrt(Math.pow(xdist,2)+Math.pow(ydist,2));
        if(dist>=pointdist){return true;}else{return false;}
    }
    static void dfs(int node){
        visited[node] = true;
        for(int nect: adj[node]){
            if(!visited[nect]){
                dfs(nect);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("moocast");
        n = io.nextInt();
        x = new int[n];
        y = new int[n];
        radii = new int[n];
        visited = new boolean[n];
        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            x[i] = io.nextInt();
            y[i] = io.nextInt();
            radii[i] = io.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(pointsindist(x[i], y[i], x[j], y[j], radii[i])){
                        adj[i].add(j);
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                visited[j] = false;
            }
            dfs(i);
            for(int j=0;j<n;j++){
                if(visited[j]){count++;}
            }
            ans = Math.max(count,ans);
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
