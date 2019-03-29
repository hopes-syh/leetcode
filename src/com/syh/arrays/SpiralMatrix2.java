package com.syh.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-2-16
 * Time: 上午2:02
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {

    public static void main(String[] args) {
        SpiralMatrix2 sm = new SpiralMatrix2();

        System.out.println(Arrays.deepToString(sm.generateMatrix(3)));
        System.out.println(Arrays.deepToString(sm.generateMatrix(5)));
    }

    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return null;
        }

        int y = 0, x = 0, loop = 0, stage = 1;
        int[][] result = new int[n][n];
        for(int i=1; i<=(n*n); i++){

            if(y==x && y==loop && stage != 1){
                loop++; y++; x++;
            }

            stage = 2;
            if(y == loop && x+loop < n-1 ){
                result[y][x] = i;
                x++;
                continue;
            }
            if(y+loop < n-1 && x+loop == n-1){
                result[y][x] = i;
                y++;
                continue;
            }
            if(y+loop == n-1 && x>loop){
                result[y][x] = i;
                x--;
                continue;
            }
            if(y >= loop && x == loop){
                result[y][x] = i;
                y--;
                continue;
            }

        }

        return result;
    }
}
