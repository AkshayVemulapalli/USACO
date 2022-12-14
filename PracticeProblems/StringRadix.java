package com.company.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class StringRadix {
    static int cti(char c){
        return (int)c -96;
    }
    public static Map<Character, Integer> cti = new HashMap<>();
    public static void stringRadixSort(List<String> list) {
        if (list.size() <= 1) {
            return;
        }

        List<String>[] buckets = new List[43];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        int largestLength = -1;
        int secondLargestLength = 0;
        for (String s : list) {
            int length = s.length();
            if (length >= largestLength) {
                secondLargestLength = largestLength;
                largestLength = length;
            } else if (secondLargestLength < length) {
                secondLargestLength = length;
            }
        }


        for (int i = secondLargestLength == largestLength ? secondLargestLength-1 : secondLargestLength; i >= 0; i--) {
            for (String word : list) {
                int index = (word.length() <= i) ? 0 : cti.get(word.charAt(i))-1;
                buckets[index].add(word);
            }

            list.clear();

            for (List<String> lst : buckets) {
                if (lst != null) {
                    list.addAll(lst);
                    lst.clear();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<String> in = new ArrayList<>();
        String str;
        while((str=r.readLine())!=null){
            in.add(str.toLowerCase());
        }

        //ArrayList<String> in = new ArrayList<>(Arrays.asList("death", "ketamine", "poop", "apples", "bone","Capital", "banana","pee", "bodacious", "come", "adult", "cart", "cant", "darn"));
        //int n = in.size();
        for(char c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            cti.put(c,cti(c));
        }
        for(int i=0;i<1;i++){
            cti.put('??',27);
            cti.put('??',28);
            cti.put('??',29);
            cti.put('??',30);
            cti.put('??',31);
            cti.put('??',32);
            cti.put('??',33);
            cti.put('??',34);
            cti.put('??',35);
            cti.put('??',36);
            cti.put('??',37);
            cti.put('??',38);
            cti.put('??',39);
            cti.put('??',40);
            cti.put('??',41);
            cti.put('??',42);
            cti.put('\'',43);
            cti.put('-',44);
        }
        stringRadixSort(in);
        System.out.println(in);
    }
}
