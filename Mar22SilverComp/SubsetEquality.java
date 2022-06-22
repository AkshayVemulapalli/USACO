//package com.company.SilverComp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubsetEquality {
    static int q;
    static String s;
    static String t;
    static int[] sc = new int[18];
    static int[] tc = new int[18];
    static int sn;
    static int tn;
    static HashMap<String, Boolean> subsets = new HashMap<>((1 << 18) + 1,1);
    static boolean test(String query){
        int n = query.length();
        if(n==1){
            return (sc[cti(query.charAt(0))]==tc[cti(query.charAt(0))]);
        }else {
            if (subsets.containsKey(query)) {
                return subsets.get(query);
            } else {
                if (n==2) {
                    if(sc[cti(query.charAt(0))]!=tc[cti(query.charAt(0))]){
                        subsets.put(query, false);
                        return false;
                    }
                    if(sc[cti(query.charAt(1))]!=tc[cti(query.charAt(1))]){
                        subsets.put(query, false);
                        return false;
                    }
                    boolean result = tl(query.charAt(0),query.charAt(1));
                    subsets.put(query, result);
                    return result;
                } else {
                    if(n==3){
                        if(!test(query.substring(1))){
                            subsets.put(query, false);
                            return false;
                        }
                        if(!test(query.substring(0,2))){
                            subsets.put(query, false);
                            return false;
                        }
                        if(!test(query.substring(0,1).concat(query.substring(2)))){
                            subsets.put(query, false);
                            return false;
                        }
                        subsets.put(query, true);
                        return true;
                    }else{
                        for(int i=0;i<n-1;i++){
                            if(!test(query.substring(0, i).concat(query.substring(i + 1)))){
                                subsets.put(query, false);
                                return false;
                            }
                        }
                        subsets.put(query, true);
                        return true;
                    }
                }
            }
        }
    }
    static boolean tl(char a, char b){
        ArrayList<Character> sarr = new ArrayList<>();
        ArrayList<Character> tarr = new ArrayList<>();
        for(int i=0;i<sn;i++){
            char ch = s.charAt(i);
            if(ch==a || ch==b){
                sarr.add(s.charAt(i));
            }
        }
        for(int i=0;i<tn;i++){
            char ch = t.charAt(i);
            if(ch==a || ch==b){
                tarr.add(t.charAt(i));
            }
        }
        if(sarr.equals(tarr)){
            return true;
        }else{
            return false;
        }
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
