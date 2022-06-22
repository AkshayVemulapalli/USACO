package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class ClosingTheFarm {
    static int n,m;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static ArrayList<Integer> opens;
    static boolean alltrue(boolean[] arr){
        for(int i=0;i<n;i++){
            if(!arr[i]){return false;}
        }
        return true;
    }
    static void dfs(int node){
        visited[node] = true;
        for(int nect: adj[node]){
            if (!visited[nect]) {
                dfs(nect);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("closing");
        n = io.nextInt();
        m = io.nextInt();
        adj = new ArrayList[n];
        visited = new boolean[n];
        opens = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<Integer>();
            opens.add(i);
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            adj[b-1].add(a-1);
            adj[a-1].add(b-1);
        }
        for(int i=0;i<n;i++){
            for(int barn: opens){
                visited[barn] = false;
            }
            dfs(opens.get(0));
            if(alltrue(visited)){
                io.println("YES");
            }else{
                io.println("NO");
            }
            int remove = io.nextInt()-1;
            visited[remove] = true;
            adj[remove] = new ArrayList<>();
            opens.remove(new Integer(remove));
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
