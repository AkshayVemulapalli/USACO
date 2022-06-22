package com.company;

import java.io.*;
import java.util.*;


public class Dec2021Prob1 {
    public static void main(String[] args) throws IOException {
        // write your code here
        Kattio io = new Kattio();
        int n = io.nextInt();
        String line = io.next();
        long throwcount = 0;
        for(int i=0;i<n;i++){
            int gcount = 0;
            int hcount = 0;
            for(int j=i;j<n;j++){
                if (line.charAt(j)=='G'){
                    gcount+=1;
                }else{
                    hcount+=1;
                }
                if(j>=(i+2)){
                    if (gcount>=2 && hcount>=2){
                        break;
                    }else if(gcount==1 || hcount==1){
                        throwcount+=1;
                    }
                }
            }
        }
        io.print(throwcount);
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in,System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}

            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
