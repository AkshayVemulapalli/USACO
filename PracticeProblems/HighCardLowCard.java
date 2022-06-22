package com.company.practice.greedyAlgs;

import java.io.*;
import java.util.StringTokenizer;

public class HighCardLowCard {
    static int n;
    static int[] countingSort(int[] input) {
        int counter[] = new int[2*n+1]; // fill buckets
        for (int i : input) {
            counter[i]++;
        }
        int dex = 0;
        for(int i=0;i<counter.length;i++){
            while(counter[i]>0){
                input[dex++] = i;
                counter[i]--;
            }
        }
        return input;
    }
    public static void main(String[] args) throws IOException{
        //read key club stuff
        Kattio io = new Kattio("cardgame");
        n = io.nextInt();
        int ans = 0;
        int[] ecards1 = new int[n/2];
        int[] ecards2 = new int[n/2];
        int[] ecards = new int[n];
        int mid = n/2;
        for(int i=0;i<n;i++){
            int x = io.nextInt();
            if(i<mid) {
                ecards1[i] = x;
            }else{
                ecards2[i-mid] = x;
            }
            ecards[i] = x;
        }
        ecards1 = countingSort(ecards1);
        ecards2 = countingSort(ecards2);
        ecards = countingSort(ecards);
        int epointer = 0;
        int bpointer = 0;
        int[] bcards = new int[n];
        for(int i=1;i<2*n+1;i++){
            if(epointer == n || i!=ecards[epointer]){
                bcards[bpointer] = i;
                bpointer++;
            }else{
                epointer++;
            }
        }
        int ix = bcards.length - 1;
        for(int i=n/2-1;i>=0;i--){
            if(ecards1[i] < bcards[ix]){
                ans++;
                ix--;
            }
        }
        ix = 0;
        for(int i=0;i<n/2;i++){
            if(bcards[ix]<ecards2[i]){
                ix++;
                ans++;
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
