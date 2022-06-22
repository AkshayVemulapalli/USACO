package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class CountingRoomsDFS {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static void dfs(int node){
        visited[node]=true;
        for(int nect: adj[node]){
            if(!visited[nect]){
                dfs(nect);
            }
        }
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        int[][] map = new int[n][m];
        int ans = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            char[] crow = io.next().toCharArray();
            int[] row = new int[m];
            for(int j=0;j<m;j++){
                if(crow[j]=='.'){
                    count++;
                    row[j] = count;
                }
            }
            map[i] = row;
        }
        adj = new ArrayList[count+1];
        visited = new boolean[count+1];
        for(int i=1;i<=count;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!=0) {
                    if (i != 0) {
                        if (map[i - 1][j] != 0) {
                            adj[map[i][j]].add(map[i - 1][j]);
                        }
                    }
                    if (j != 0) {
                        if (map[i][j-1] != 0) {
                            adj[map[i][j]].add(map[i][j-1]);
                        }
                    }
                    if (i != n-1) {
                        if (map[i + 1][j] != 0) {
                            adj[map[i][j]].add(map[i + 1][j]);
                        }
                    }
                    if (j != m-1) {
                        if (map[i][j+1] != 0) {
                            adj[map[i][j]].add(map[i][j+1]);
                        }
                    }
                }
            }
        }
        for(int i=1;i<=count;i++){
            if(!visited[i]){
                ans++;
                dfs(i);
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
