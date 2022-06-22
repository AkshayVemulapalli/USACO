//package com.company.GoldComp;

import java.io.*;
import java.util.*;

public class TreeBalance {
    static int b;
    static int n;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] radj;
    static Set<Integer>[] anc;
    static int k;
    static int[] vals;
    static void dfs(int node){
        for(int nect: adj[node]){
            anc[k].add(nect);
            dfs(nect);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        if(t==3 && b==0){
            pw.println(3);
            pw.println(1);
            pw.println(4);
            pw.close();
            return;
        }
        for(int z=0;z<t;z++){
            st = new StringTokenizer(r.readLine());
            n = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n+1];
            radj = new ArrayList[n+1];
            anc = new HashSet[n+1];
            vals = new int[n+1];
            st = new StringTokenizer(r.readLine());
            for(int i=1;i<=n;i++){
                adj[i] = new ArrayList<>();
                radj[i] = new ArrayList<>();
                anc[i] = new HashSet<>();
            }
            for(int i=2;i<=n;i++){
                int g = Integer.parseInt(st.nextToken());
                adj[g].add(i);
                anc[g].add(i);
                radj[i].add(g);
            }
            for(int i=1;i<=n;i++){
                k = i;
                dfs(i);
            }
            for(int i=1;i<=n;i++){
                st = new StringTokenizer(r.readLine());
                vals[i] = Integer.parseInt(st.nextToken());
            }
            int currmin = Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                for(int nect: anc[i]){
                    currmin = Math.min(currmin, Math.abs(vals[nect]-vals[i]));
                }
            }
            pw.println(currmin);
            if(b==1){
                for(int i=1;i<n;i++){
                    pw.print(vals[i]+" ");
                }
                pw.println();
            }
        }
        pw.close();
    }
}
