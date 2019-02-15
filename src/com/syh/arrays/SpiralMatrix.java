package com.syh.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-2-16
 * Time: 上午2:02
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        System.out.println(sm.spiralOrder(matrix));

        int[][] matrix2 = new int[3][4];
        matrix2[0] = new int[]{1,2,3,4};
        matrix2[1] = new int[]{5,6,7,8};
        matrix2[2] = new int[]{9,10,11,12};
        System.out.println(sm.spiralOrder(matrix2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int ylen = matrix.length;
        if(ylen<=0){
            return result;
        }
        int xlen = matrix[0].length;
        if(xlen<=0){
            return result;
        }

        int y = 0, x = 0, total = ylen * xlen;
        int ystart=0, yend=0, xstart=0, xend=0;
        while (result.size() < total){
            for(x=xstart; x<xlen; x++){
                result.add(matrix[y][x]);
            }
            ystart++; yend++; x--;
            if(result.size() == total) break;

            for(y=ystart; y<ylen; y++){
                result.add(matrix[y][x]);
            }
            xlen--; y--; x--;
            if(result.size() == total) break;

            for(; x>=xend; x--){
                result.add(matrix[y][x]);
            }
            ylen--; y--; x++;
            if(result.size() == total) break;

            for(; y>=yend; y--){
                result.add(matrix[y][x]);
            }
            xstart++; xend++; y++;
            if(result.size() == total) break;
        }

        return result;
    }
}
