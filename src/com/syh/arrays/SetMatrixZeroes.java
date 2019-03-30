package com.syh.arrays;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-31
 * Time: 上午2:50
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes np = new SetMatrixZeroes();
        int[][] value;

        value = new int[3][3];
        value[0] = new int[]{1,2,3};
        value[1] = new int[]{4,0,6};
        value[2] = new int[]{7,8,9};
        np.setZeroes(value);
        System.out.println(Arrays.deepToString(value));

        value = new int[4][4];
        value[0] = new int[]{ 0, 1, 9, 0};
        value[1] = new int[]{ 2, 4, 8,10};
        value[2] = new int[]{13, 3, 6, 7};
        value[3] = new int[]{15,14,12,16};
        np.setZeroes(value);
        System.out.println(Arrays.deepToString(value));
    }

    public void setZeroes(int[][] matrix) {
        if(matrix.length <= 0 || matrix[0].length <= 0){
            return;
        }

        int ysize = matrix.length, xsize = matrix[0].length;
        byte[] yr = new byte[xsize];
        int xr;
        for(int y=0; y<ysize; y++){
            xr = 0;

            for(int x=0; x<xsize; x++){
                if(matrix[y][x] == 0){
                    xr++;
                    yr[x] = (byte) 1;
                }
            }

            if(xr > 0){
                for(int x=0; x<xsize; x++)
                    matrix[y][x] = 0;
            }
        }

        for(int x=0; x<xsize; x++){
            if((byte) 1 == yr[x]){
                for(int y=0; y<ysize; y++){
                    matrix[y][x] = 0;
                }
            }
        }
    }
}
