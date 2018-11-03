package com.syh.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-3
 * Time: 上午9:43
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum sum = new MinimumPathSum();

        int[][] grid = new int[2][2];
        grid[0] = new int[]{1,3};
        grid[1] = new int[]{1,5};
        System.out.println(sum.minPathSum(grid));

        grid = new int[3][3];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};
        System.out.println(sum.minPathSum(grid));

        grid = new int[3][3];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,1,5};
        grid[2] = new int[]{4,2,1};
        System.out.println(sum.minPathSum(grid));
    }

    /**
     * 解法1
     */
    public int minPathSum(int[][] grid) {
        if(grid.length<=0){
            return 0;
        }

        for(int i=1; i<grid.length; i++){
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for(int i=1; i<grid[0].length; i++){
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }

        int x = grid[0].length-1, y = grid.length-1;
        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[y][x];
    }

    /**
     * 解法1
     */
    public int minPathSum1(int[][] grid) {
        if(grid.length<=0){
            return 0;
        }

        int y = grid.length, x = grid[0].length;
        int[][] sumArr = new int[y][x];
        sumArr[0][0] = grid[0][0];
        return dp(sumArr, grid, x-1, y-1);
    }

    private int dp(int[][] sumArr, int[][] grid, int x, int y) {
        if(x<0 || y<0){
            return Integer.MAX_VALUE;
        }
        if(x==0 && y==0){
            return grid[y][x];
        }
        else if(sumArr[y][x] != 0){
            return sumArr[y][x];
        }

        int xSum = dp(sumArr, grid, x-1, y);
        int ySum = dp(sumArr, grid, x, y-1);
        sumArr[y][x] = Math.min(xSum, ySum) + grid[y][x];

        return sumArr[y][x];
    }
}
