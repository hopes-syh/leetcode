package com.syh.dynamic;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 **/
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths kuohao = new UniquePaths();
        System.out.println(kuohao.uniquePaths(3, 2));
        System.out.println(kuohao.uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n){
        int[][] result = new int[m][n];

        doUniquePaths(result, m, n);
        return result[m-1][n-1];
    }

    public int doUniquePaths(int[][]result, int m, int n){

        if(result[m-1][n-1] != 0){
            return result[m-1][n-1];
        }
        if(m<=0 || n<=0){
            result[m-1][n-1] = 0;
            return 0;
        }
        if(m==1 || n==1){
            result[m-1][n-1] = 1;
            return 1;
        }

        result[m-1][n-1] = doUniquePaths(result, m, n-1) + doUniquePaths(result, m-1, n);

        return result[m-1][n-1];
    }
}
