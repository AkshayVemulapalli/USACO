package com.company.SilverComp;

import java.io.*;
import java.util.*;

public class COWOperations {
    static String s;
    static char[] p;
    static char as(char a, char b){
        if(a==b){
            return '-';
        }
        if(a=='-'){
            return b;
        }
        if(b=='-'){
            return a;
        }
        if(a!='O'&&b!='O'){
            return 'O';
        }
        if(a!='W'&&b!='W'){
            return 'W';
        }
        return 'C';
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        s = st.nextToken();
        int n = s.length();
        p = new char[n+1];
        p[0] = '-';
        for(int i=1;i<=n;i++){
            p[i] = as(s.charAt(i-1),p[i-1]);
        }
        st = new StringTokenizer(r.readLine());
        int q = Integer.parseInt(st.nextToken());
        for(int i=0;i<q;i++){
            st = new StringTokenizer(r.readLine());
            if('C'==as(p[Integer.parseInt(st.nextToken())-1],p[Integer.parseInt(st.nextToken())])){
                pw.print("Y");
            }else{pw.print("N");}
        }
        pw.close();
    }
}
