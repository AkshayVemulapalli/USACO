package com.company.practice.graphProblems;


import java.io.*;
import java.util.*;

public class CountingRoomsFloodFill {
    static boolean[][] visited;
    static char[][] map;
    static int n,m;
    static void floodfill(int r, int c, char color, int n, int m) {
        boolean bool = (r < 0 || r >= n || c < 0 || c >= m)  || map[r][c] != color || visited[r][c];
        if (bool) return;
        visited[r][c] = true; // mark current square as visited
        // recursively call flood fill for neighboring squares
        if(c<m-1) {
            floodfill(r, c + 1, color, n, m);
        }
        if(c>0) {
            floodfill(r, c - 1, color, n, m);
        }
        if(r>0) {
            floodfill(r - 1, c, color, n, m);
        }
        if(r<n-1) {
            floodfill(r + 1, c, color, n, m);
        }
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            char[] row = io.next().toCharArray();
            map[i] = row;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]=='.'){
                    ans++;
                    floodfill(i,j,'.', n, m);
                }
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
