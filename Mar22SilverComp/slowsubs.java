//package com.company.SilverComp;

import java.io.*;
import java.util.*;

public class slowsubs {
    static int q;
    static String s;
    static String t;
    static int sn;
    static int tn;
    static boolean test(String query){
        ArrayList<Character> sarr = new ArrayList<>();
        ArrayList<Character> tarr = new ArrayList<>();
        for(int i=0;i<sn;i++){
            if(query.contains(Character.toString(s.charAt(i)))){
                sarr.add(s.charAt(i));
            }
        }
        for(int i=0;i<tn;i++){
            if(query.contains(Character.toString(t.charAt(i)))){
                tarr.add(t.charAt(i));
            }
        }
        if(sarr.equals(tarr)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        s = st.nextToken();
        st = new StringTokenizer(r.readLine());
        t = st.nextToken();
        sn = s.length();
        tn = t.length();
        st = new StringTokenizer(r.readLine());
        q = Integer.parseInt(st.nextToken());
        for(int i=0;i<q;i++){
            st = new StringTokenizer(r.readLine());
            if(test(st.nextToken())){
                pw.print("Y");
            }else{
                pw.print("N");
            }
        }
        pw.println();
        pw.close();
    }
}
