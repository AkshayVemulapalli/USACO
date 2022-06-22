package com.company.practice.prefixSums;

import java.util.ArrayList;
import java.util.Arrays;

public class PrefixSums2D {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] arr = new int[][]{{1,5,6,11,8},
                                  {1,7,11,9,4},
                                  {4,6,1,3,2},
                                  {7,5,4,3,2}};
        int[][] p2d = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                p2d[i][j] = p2d[i-1][j] + p2d[i][j-1] - p2d[i-1][j-1] + arr[i-1][j-1];
            }
        }
        System.out.println(Arrays.deepToString(p2d));
        //[0, 0, 0, 0, 0, 0]
        //[0, 1, 6, 12, 23, 31]
        //[0, 2, 14, 31, 51, 63]
        //[0, 6, 24, 42, 65, 79]
        //[0, 13, 36, 58, 84, 100]
        //------------------------------------------
        //partial query from 1,1 to 2,2 of original array
        //[7,11],[6,1]
        System.out.println(p2d[3][3] - p2d[3][1] - p2d[1][3] + p2d[1][1]);
        //partial query from 1,1 to 3,2 of orignal array
        System.out.println(p2d[3][4] - p2d[3][1] - p2d[1][4] + p2d[1][1]);
    }
}
