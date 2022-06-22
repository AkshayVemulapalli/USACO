package com.company;

import java.io.*;
import java.util.*;

public class Dec2021Prob2 {
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
    static int[] command(int[] delta, int startdex, int enddex, int incrementby){
        for(int i=startdex;i<=enddex;i++){
            delta[i] -= incrementby;
        }
        return delta;
    }
    static int[] findex(int[] delta, int stdex){
        int sdex = -1;
        int edex = delta.length-1;
        int negpos = 0;
        for(int i=stdex;i<delta.length;i++){
            if (sdex==-1){
                    if(delta[i] != 0) {
                        negpos = Integer.signum(delta[i]);
                        sdex = i;
                    }
            }else if(negpos!=Integer.signum(delta[i])){
                edex = i-1;
                break;
            }
        }
        int min = 100001;
        for(int i=sdex;i<=edex;i++){
            min = Math.min(min, Math.abs(delta[i]));
        }
        min *= negpos;
        return new int[]{sdex, edex, min};
    }
    static boolean checkdelta(int array[],int sdex)
    {
        for (int i = sdex; i < array.length; i++)
        {
            if(array[i] != 0)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] preferences = new int[n];
        int[] delta = new int[n];
        for(int i=0;i<n;i++){
            preferences[i] = io.nextInt();
        }
        for(int i=0;i<n;i++){
            delta[i] = preferences[i]-io.nextInt();
        }
        int[] findex = new int[]{0,0,0};
        int count = 0;
        while(checkdelta(delta,findex[0])){
            findex = findex(delta,findex[0]);
            command(delta, findex[0], findex[1], findex[2]);
            count+=Math.abs(findex[2]);
        }
        io.println(count);
        io.close();
    }
}
