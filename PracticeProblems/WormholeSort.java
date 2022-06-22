package com.company.practice.graphProblems;

import java.io.*;
import java.util.*;

public class WormholeSort {
    static int n,m;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static Edge[] edges;
    static int[] arr;
    static void dfs(int node){
        visited[node] = true;
        for(int nect: adj[node]){
            if(!visited[nect]){
                dfs(nect);
            }
        }
    }
    static boolean testw(int minw){
        ArrayList<Edge> nedges = new ArrayList<>();
        for(int i=0;i<m;i++){
            Edge hi = edges[i];
            if(hi.w>=minw){
                nedges.add(edges[i]);
            }
        }
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        for(Edge nedge: nedges){
            adj[nedge.a].add(nedge.b);
            adj[nedge.b].add(nedge.a);
        }
        int start = -1;
        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                start = i;
                break;
            }
        }
        dfs(start);
        for(int i=1;i<n+1;i++){
            if(arr[i-1]==i){
                visited[i] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static int lastTrue(int lo, int hi) {
        // if none of the values in the range work, return lo - 1
        lo--;
        while (lo < hi) {
            // find the middle of the current range (rounding up)
            int mid = lo + (hi - lo + 1) / 2 ;
            if (testw(edges[mid].w)) {
                // if mid works, then all numbers smaller than mid also work
                lo = mid;
            } else {
                // if mid does not work, greater values would not work either
                hi = mid - 1;
            }
        }
        if(lo!=-1){
            return edges[lo].w;
        }
        return lo;
    }
    public static void main(String[] args) throws IOException{
        long startTime = System.currentTimeMillis();
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        arr = new int[n];
        edges = new Edge[m];
        for(int i=0;i<n;i++){
            arr[i] = io.nextInt();
        }
        int yeet = 1;
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                yeet = 0;
            }
        }
        if(yeet==1){
            io.println("-1");
            io.close();
            return;
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            int w = io.nextInt();
            edges[i] = new Edge(a,b,w);
        }
        Arrays.sort(edges);
        io.println(lastTrue(0,m));
        long endTime = System.currentTimeMillis();
        io.println(endTime-startTime + "ms");
        io.close();
    }
    static class Edge implements Comparable<Edge>{
        int a, b, w;
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        public int compareTo(Edge y){
            return Integer.compare(w,y.w);
        }
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
