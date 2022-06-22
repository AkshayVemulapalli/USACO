package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConnectingTwoBarns {
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
    static int[] findgaps(int[] fields){
        for(int i=0;i<fields.length;i++){
            int sdex = -1;
            int edex = -1;
            if(sdex==-1 && fields[i]==0){
                sdex = i;
            }
            if(sdex!=-1 && fields[i]==1){
                edex = i-1;
            }
        }
        return fields;
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        for(int q=0;q<t;q++){
            int n = io.nextInt();
            int m = io.nextInt();
            int[] fields = new int[n-1];
            for(int i=0;i<n-1;i++){
                fields[i] = 0;
            }
            for(int i=0;i<m;i++){
                int sdex = io.nextInt();
                int edex = io.nextInt();
                for(int j=sdex-1;j<edex-1;j++){
                    fields[j] = 1;
                }
            }

        }
        io.close();
    }
}
