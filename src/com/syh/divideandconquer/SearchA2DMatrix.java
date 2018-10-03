package com.syh.divideandconquer;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-8-5
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,   4,  7, 11, 15};
        matrix[1] = new int[]{2,   5,  8, 12, 19};
        matrix[2] = new int[]{3,   6,  9, 16, 22};
        matrix[3] = new int[]{10, 13, 14, 17, 24};
        matrix[4] = new int[]{18, 21, 23, 26, 30};

        System.out.println(searchMatrix(matrix, 4 )); // 25
        System.out.println(searchMatrix(matrix, 20)); // 25
        System.out.println(searchMatrix(matrix, 55)); // 25

        matrix = new int[1][2];
        matrix[0] = new int[]{-1, 3};
        System.out.println(searchMatrix(matrix, 1 )); // 25

        matrix = new int[5][5];
        matrix[0] = new int[]{1, 2, 3, 4, 5};
        matrix[1] = new int[]{6, 7, 8, 9, 10};
        matrix[2] = new int[]{11,12,13,14,15};
        matrix[3] = new int[]{16,17,18,19,20};
        matrix[4] = new int[]{21,22,23,24,25};
        System.out.println(searchMatrix(matrix, 15 ));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length<=0 || matrix[0].length<=0){
            return false;
        }

        int m=matrix.length, n=matrix[0].length;
        int r=0,c=n-1;
        while(r<m&&c>=0){
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]<target) r++;
            else c--;
        }
        return false;
    }
}
