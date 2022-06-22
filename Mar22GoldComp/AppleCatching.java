//package com.company.GoldComp;

import java.io.*;
import java.util.*;

public class AppleCatching {
    static int n;
    static int ans;
    static ArrayList<CowGroup> cows = new ArrayList<>();
    static ArrayList<AppleGroup> apples = new ArrayList<>();
    static In[] ins;
    static class CowGroup{
        int t; //time
        int p; //position
        int n; //num
        public CowGroup(int t, int p, int n) {
            this.t = t;
            this.p = p;
            this.n = n;
        }
        public String toString() {
            return "CowGroup{" +
                    "t=" + t +
                    ", p=" + p +
                    ", n=" + n +
                    '}';
        }
    }
    static class AppleGroup{
        int t; //time
        int p; //position
        int n; //num
        public AppleGroup(int t, int p, int n) {
            this.t = t;
            this.p = p;
            this.n = n;
        }
        public String toString() {
            return "AppleGroup{" +
                    "t=" + t +
                    ", p=" + p +
                    ", n=" + n +
                    '}';
        }
    }
    static class In implements Comparable<In>{
        int ac, t, p, n;
        public In(int ac, int t, int p, int n) {
            this.ac = ac;
            this.t = t;
            this.p = p;
            this.n = n;
        }
        public int compareTo(In o) {
            return Integer.compare(t, o.t);
        }
        public String toString() {
            return "In{" +
                    "ac=" + ac +
                    ", t=" + t +
                    ", p=" + p +
                    ", n=" + n +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        ins = new In[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(r.readLine());
            int q = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            ins[i] = new In(q,t,x,n);
        }
        Arrays.sort(ins);
        for(In g: ins){
            if(g.ac==1){
                cows.add(new CowGroup(g.t, g.p, g.n));
            }else{
                apples.add(new AppleGroup(g.t,g.p,g.n));
            }
        }
        for(AppleGroup i: apples){
            if(i.n==0){
                continue;
            }
            for(CowGroup j: cows){
                if(j.n==0){
                    continue;
                }
                if(j.t>i.t){
                    break;
                }
                if(Math.abs(i.p-j.p)<=(i.t-j.t)){
                    if(j.n>i.n){
                        j.n-=i.n;
                        ans+=i.n;
                        i.n = 0;
                    }else if(i.n>j.n){
                        i.n-=j.n;
                        ans+=j.n;
                        j.n = 0;
                    }else{
                        ans+=i.n;
                        i.n = 0;
                        j.n = 0;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
