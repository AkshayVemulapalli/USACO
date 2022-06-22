package com.company.practice.graphProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FlightRoutesCheck {
    static Kattio io;
    static int n,m;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] radj;
    static boolean[] visited;
    static void dfs(int node, ArrayList<Integer>[] adj){
        visited[node] = true;
        for(int nect: adj[node]){
            if(!visited[nect]){
                dfs(nect, adj);
            }
        }
    }
    static int alltrue(boolean[] visited){
        for(int i=0;i<n;i++){
            if(!visited[i]){return i;}
        }
        return -1;
    }
    public static void main(String[] args) {
        io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        visited = new boolean[n];
        adj = new ArrayList[n];
        radj = new ArrayList[n];;
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a-1].add(b-1);
            radj[b-1].add(a-1);
        }
        dfs(0, adj);
        int yo = alltrue(visited);
        if(yo!=-1){
            System.out.println("NO");
            System.out.println("1 "+(yo+1));
            return;
        }
        for(int i=0;i<n;i++){
            visited[i] = false;
        }
        dfs(0, radj);
        yo = alltrue(visited);
        if(yo!=-1){
            System.out.println("NO");
            System.out.println((yo+1)+" 1");
            return;
        }
        System.out.println("YES");
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
