//package com.company.practice.graphProblems;

import java.io.*;
import java.util.*;

public class DanceMooves {
    static int n,k;
    static int[] arr;
    static ArrayList<Integer>[] adjs;
    static int[] adj;
    static Set<Integer> sc;
    static boolean[] visited;
    static int[] ans;
    static Set<Integer> sn;
    static void dfs(int node){
        visited[node] = true;
        sn.add(node);
        sc.addAll(adjs[node]);
        if(!visited[adj[node]]){dfs(adj[node]);}
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        k = io.nextInt();
        arr = new int[n+1];
        adjs = new ArrayList[n+1];
        adj = new int[n+1];
        ans = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
            adjs[i] = new ArrayList<>();
        }
        for(int i=1;i<=k;i++){
            int a = io.nextInt();
            int b = io.nextInt();
            adjs[arr[a]].add(b);
            adjs[arr[b]].add(a);
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        for(int i=1;i<=n;i++){
            if(adjs[i].size()!=0) {
                adj[i] = adjs[i].get(adjs[i].size() - 1);
            }else{adj[i]=i;}
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                sc = new HashSet<>();
                sn = new HashSet<>();
                dfs(i);
                int count = sc.size();
                for(int hi: sn){
                    ans[hi] = count;
                }
            }
        }
        for(int i=1;i<=n;i++){
            int hi = ans[i];
            if(hi==0){io.println(1);}else{io.println(hi);}
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
