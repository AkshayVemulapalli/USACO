package com.company.practice.prefixSums;

import java.io.*;
import java.util.StringTokenizer;

public class SubSequences7 {
    static int n;
    static int[] IDs;
    static int[] psums;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("div7");
        n = io.nextInt();
        IDs = new int[n];
        for(int i=0;i<n;i++){
            IDs[i] = io.nextInt()%7;
        }
        psums = new int[n+1];
        psums[0] = 0;
        for(int i=1;i<n+1;i++){
            psums[i] = (psums[i-1] + IDs[i-1])%7;
        }
        for(int i=0;i<7;i++){
            int sdex = -1;
            int edex = -1;
            for(int j=0;j<n+1;j++){
                if(psums[j]==i){
                    sdex = j;
                    break;
                }
            }
            for(int j=n;j>-1;j--){
                if(psums[j]==i){
                    edex = j;
                    break;
                }
            }
            if (sdex == edex || sdex == -1) {
                ans = Math.max(ans,0);
            }else{
                ans = Math.max(ans, edex-sdex);
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
