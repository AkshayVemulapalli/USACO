package com.company.SilverComp;

import java.io.*;
import java.util.*;

public class Subsets {
    static int q;
    static String s;
    static String t;
    static int[] sc = new int[18];
    static int[] tc = new int[18];
    static int sn;
    static int tn;
    static HashMap<String, Boolean> twosets = new HashMap<>(200,1);
    static boolean test(String query){
        int n = query.length();
        if(n==0){return true;}
        if(n==1){
            return (sc[cti(query.charAt(0))]==tc[cti(query.charAt(0))]);
        }else {
            if (n==2){
                return twoq(query.charAt(0), query.charAt(1));
            }else {
                for(int i=0;i<n-1;i++){
                    for(int j=i+1;j<n;j++){
                        if(!twoq(query.charAt(i),query.charAt(j))){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }
    static boolean twoq(char a, char b){
        String str = new String(new char[]{a,b});
        if(twosets.containsKey(str)){
            return twosets.get(str);
        }else {
            if(!(sc[cti(a)]==tc[cti(a)])){
                twosets.put(str,false);
                return false;
            }
            if(!(sc[cti(b)]==tc[cti(b)])){
                twosets.put(str,false);
                return false;
            }
            ArrayList<Character> sarr = new ArrayList<>();
            for (int i = 0; i < sn; i++) {
                char ch = s.charAt(i);
                if (ch == a || ch == b) {
                    sarr.add(ch);
                }
            }
            int count = 0;
            for (int i = 0; i < tn; i++) {
                char ch = t.charAt(i);
                if (ch == a || ch == b) {
                    if (sarr.get(count) != ch) {
                        twosets.put(str,false);
                        return false;
                    } else {
                        count++;
                    }
                }
            }
        }
        twosets.put(str,true);
        return true;
    }
    static int cti(char c){
        return (char)(c - 'a');
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
        for(int i=0;i<sn;i++){
            sc[cti(s.charAt(i))]++;
        }
        for(int i=0;i<tn;i++){
            tc[cti(t.charAt(i))]++;
        }
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
