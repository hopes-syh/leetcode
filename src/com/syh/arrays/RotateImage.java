package com.syh.arrays;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-10
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 */
public class RotateImage {
    public static void main(String[] args) {
        RotateImage np = new RotateImage();
        int[][] value;

        value = new int[3][3];
        value[0] = new int[]{1,2,3};
        value[1] = new int[]{4,5,6};
        value[2] = new int[]{7,8,9};
        np.rotate(value);
        System.out.println(Arrays.deepToString(value));

        value = new int[4][4];
        value[0] = new int[]{ 5, 1, 9,11};
        value[1] = new int[]{ 2, 4, 8,10};
        value[2] = new int[]{13, 3, 6, 7};
        value[3] = new int[]{15,14,12,16};
        np.rotate(value);
        System.out.println(Arrays.deepToString(value));
    }

    public void rotate(int[][] matrix) {
        if(matrix.length<=0 || matrix[0].length<=0){
            return;
        }
        if(matrix.length == 1){
            return;
        }

        int osize = matrix.length;
        int y = 0, x = 0;
        while (true){
            int dsize = osize - 1;
            for(int i=x; i<dsize; i++){
                int ty = i, tx = dsize;
                int alert = matrix[y][i], tmp = matrix[ty][tx];
                matrix[ty][tx] = alert;

                int tty = ty;
                ty = tx; tx = dsize - tty + x;
                alert = tmp; tmp = matrix[ty][tx];
                matrix[ty][tx] = alert;

                tty = ty;
                ty = tx; tx = dsize - tty + x;
                alert = tmp; tmp = matrix[ty][tx];
                matrix[ty][tx] = alert;

                tty = ty;
                ty = tx; tx = dsize - tty + x;
                alert = tmp; tmp = matrix[ty][tx];
                matrix[ty][tx] = alert;
            }

            y++; x++;
            osize = dsize;
            if(osize <= 1)
                break;
        }
    }
}
