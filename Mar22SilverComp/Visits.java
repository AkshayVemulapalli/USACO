//package com.company.SilverComp;

import java.io.*;
import java.util.*;

public class Visits {
    static int n;
    static long m = 0;
    static int cm;
    static long ans;
    static boolean[] v;
    static boolean[] vc;
    static ArrayList<Integer> c = new ArrayList<>();
    static int[][] a;
    static void findcycle(int g){
        v[g] = true;
        vc[g] = true;
        if(vc[a[g][0]]){
            c.add(a[g][0]);
        }
        if(!v[a[g][0]]) {
            findcycle(a[g][0]);
        }
    }
    static void findmin(int g){
        if(!vc[g]) {
            vc[g] = true;
            cm = Math.min(cm, a[g][1]);
            findmin(a[g][0]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        v = new boolean[n+1];
        a = new int[n+1][2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(r.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            int moos = Integer.parseInt(st.nextToken());
            a[i][1] = moos;
            ans+=moos;
        }
        for(int i=1;i<=n;i++){
            vc = new boolean[n+1];
            findcycle(i);
        }
        vc = new boolean[n+1];
        for(int g:c){
            cm = Integer.MAX_VALUE;
            findmin(g);
            m+=cm;
        }
        System.out.println(ans-m);
    }
}
