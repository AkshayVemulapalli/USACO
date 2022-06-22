package com.company.practice;

import java.util.*;

public class CustomComparator {
    static class Edge implements Comparable<Edge>{
        int a,b,w;
        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
        public int compareTo(Edge y){
            return Integer.compare(w,y.w);
        }
    }
    public static void main(String[] args) {
        int M = 4;
        Scanner in = new Scanner(System.in);
        ArrayList<Edge> v = new ArrayList<Edge>();
        for (int i = 0; i < M; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            v.add(new Edge(a,b,w));
        }
        for (Edge e: v){
            System.out.print(e.a);
            System.out.print(' ');
            System.out.print(e.b);
            System.out.print(' ');
            System.out.println(e.w);
        }
        Collections.sort(v);
        System.out.println();
        for (Edge e: v){
            System.out.print(e.a);
            System.out.print(' ');
            System.out.print(e.b);
            System.out.print(' ');
            System.out.println(e.w);
        }
    }
}
