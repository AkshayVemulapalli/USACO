package com.company;

import java.io.*;
import java.util.*;

public class Dec2021Prob3 {
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
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int t = io.nextInt();
        for(int p = 0;p<t;p++){
            int n = io.nextInt();
            int k = io.nextInt();
            int count = 0;
            char[][] grid = new char[n][n];
            for(int i=0;i<n;i++){
                grid[i] = io.next().toCharArray();
            }
            if(k==1){
                int waytop = 1;
                int waybot = 1;
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H' || grid[i][n-1]=='H'){
                        waytop = 0;
                    }
                    if(grid[i][0]=='H' || grid[n-1][i]=='H'){
                        waybot = 0;
                    }
                }
                count = waytop + waybot;
            }
            if(k==2){
                //-----------------------
                int waytop = 1;
                int waybot = 1;
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H' || grid[i][n-1]=='H'){
                        waytop = 0;
                    }
                    if(grid[i][0]=='H' || grid[n-1][i]=='H'){
                        waybot = 0;
                    }
                }
                count += (waytop+waybot);
                //-------------------------
                int[] cols = new int[n-2];
                int[] rows = new int[n-2];
                Arrays.fill(cols, 1);
                Arrays.fill(rows, 1);
                for(int i=1;i<n-1;i++){
                    for(int j=1;j<n-1;j++){
                        if(grid[i][j]=='H'){
                            cols[j-1] = 0;
                            rows[i-1] = 0;
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H'){
                        for(int j=i-1;j<n-2;j++){
                            cols[j] = 0;
                            grid[0][j+1] = '.';
                        }
                    }
                    if(grid[i][0]=='H'){
                        for(int j=i-1;j<n-2;j++){
                            rows[j] = 0;
                            grid[j+1][0] = '.';
                        }
                    }
                    if(grid[n-1][i]=='H'){
                        for(int j=i-1;j>=0;j--){
                            cols[j] = 0;
                        }
                    }
                    if(grid[i][n-1]=='H'){
                        for(int j=i-1;j>=0;j--){
                            rows[j] = 0;
                        }
                    }
                }
                for(int i=0;i<n-2;i++){
                    count+=(rows[i]+cols[i]);
                }
            }
            if(k==3){
                int[][] ra = new int[n-2][n-2];
                int[][] da = new int[n-2][n-2];
                for(int[] row: ra){
                    Arrays.fill(row,1);
                }
                for(int[] row: da){
                    Arrays.fill(row,1);
                }
                for(int i=1;i<n-1;i++){
                    for(int j=1;j<n-1;j++){
                        if(grid[i][j]=='H'){
                            for(int x=0;x<j;x++){
                                ra[i-1][x]=0;
                            }
                            for(int y=i;y<n-2;y++){
                                ra[y][j-1]=0;
                            }
                            for(int x=j;x<n-2;x++){
                                da[i-1][x]=0;
                            }
                            for(int y=0;y<i;y++){
                                da[y][j-1]=0;
                            }
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H'){
                        for(int x=i-1;x<n-2;x++){
                            for(int y=0;y<n-2;y++){
                                ra[y][x]=0;
                            }
                        }
                    }
                    if(grid[n-1][i]=='H'){
                        for(int x=0;x<i;x++){
                            for(int y=0;y<n-2;y++){
                                da[y][x]=0;
                            }
                        }
                    }
                    if(grid[i][0]=='H'){
                        for(int x=0;x<n-2;x++){
                            for(int y=i-1;y<n-2;y++){
                                da[y][x]=0;
                            }
                        }
                    }
                    if(grid[i][n-1]=='H'){
                        for(int x=0;x<n-2;x++){
                            for(int y=0;y<i;y++){
                                ra[y][x]=0;
                            }
                        }
                    }
                }
                for(int i=0;i<n-2;i++)
                {
                    for(int j=0;j<n-2;j++)
                    {
                        count+=(ra[i][j]+da[i][j]);

                    }
                }
                //---------------------------------------
                //-----------------------
                int waytop = 1;
                int waybot = 1;
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H' || grid[i][n-1]=='H'){
                        waytop = 0;
                    }
                    if(grid[i][0]=='H' || grid[n-1][i]=='H'){
                        waybot = 0;
                    }
                }
                count += (waytop+waybot);
                //-------------------------
                int[] cols = new int[n-2];
                int[] rows = new int[n-2];
                Arrays.fill(cols, 1);
                Arrays.fill(rows, 1);
                for(int i=1;i<n-1;i++){
                    for(int j=1;j<n-1;j++){
                        if(grid[i][j]=='H'){
                            cols[j-1] = 0;
                            rows[i-1] = 0;
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    if(grid[0][i]=='H'){
                        for(int j=i-1;j<n-2;j++){
                            cols[j] = 0;
                            grid[0][j+1] = '.';
                        }
                    }
                    if(grid[i][0]=='H'){
                        for(int j=i-1;j<n-2;j++){
                            rows[j] = 0;
                            grid[j+1][0] = '.';
                        }
                    }
                    if(grid[n-1][i]=='H'){
                        for(int j=i-1;j>=0;j--){
                            cols[j] = 0;
                        }
                    }
                    if(grid[i][n-1]=='H'){
                        for(int j=i-1;j>=0;j--){
                            rows[j] = 0;
                        }
                    }
                }
                for(int i=0;i<n-2;i++){
                    count+=(rows[i]+cols[i]);
                }
            }
            io.println(count);
        }
        io.close();
    }
}
