package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class IcyPerimeter {
    static int n;
    static boolean[][] visited;
    static char[][] map;
    static int carea;
    static int cperim;
    static void floodfill(int r, int c, char color, int n) {
        boolean bool = (r < 0 || r >= n || c < 0 || c >= n) || visited[r][c];
        if (bool) return;
        visited[r][c] = true; // mark current square as visited
        carea++;
        // recursively call flood fill for neighboring squares
        if(c<n-1) {
            if(map[r][c+1]==color) {
                floodfill(r, c + 1, color, n);
            }else{cperim++;}
        }else{cperim++;}
        if(c>0) {
            if(map[r][c-1]==color) {
                floodfill(r, c - 1, color, n);
            }else{cperim++;}
        }else{cperim++;}
        if(r>0) {
            if(map[r-1][c]==color) {
                floodfill(r - 1, c, color, n);
            }else{cperim++;}
        }else{cperim++;}
        if(r<n-1) {
            if(map[r+1][c]==color) {
                floodfill(r + 1, c, color, n);
            }else{cperim++;}
        }else{cperim++;}
    }
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("perimeter");
        Map<Integer,Integer> ap = new HashMap<>();
        int n = io.nextInt();
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            char[] row = io.next().toCharArray();
            map[i] = row;
        }
        int marea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && map[i][j]=='#'){
                    carea = 0;
                    cperim = 0;
                    floodfill(i,j,'#', n);
                    marea = Math.max(marea, carea);
                    ap.put(carea,cperim);
                }
            }
        }
        io.println(marea + " " + ap.get(marea));
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
