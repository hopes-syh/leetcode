package com.syh.dynamic;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 **/
public class UniquePaths2 {

    public static void main(String[] args) {
        UniquePaths2 kuohao = new UniquePaths2();
        int[][] grid = null;

        grid = new int[3][2];
        grid[0] = new int[]{0,0};
        grid[1] = new int[]{1,1};
        grid[2] = new int[]{0,0};
        System.out.println(kuohao.uniquePathsWithObstacles(grid));

        grid = new int[3][3];
        grid[0] = new int[]{0,0,0};
        grid[1] = new int[]{0,1,0};
        grid[2] = new int[]{0,0,0};
        System.out.println(kuohao.uniquePathsWithObstacles(grid));

        grid = new int[3][3];
        grid[0] = new int[]{0,0,0};
        grid[1] = new int[]{0,1,0};
        grid[2] = new int[]{0,0,1};
        System.out.println(kuohao.uniquePathsWithObstacles(grid));

        grid = new int[4][4];
        grid[0] = new int[]{0,0,0,0};
        grid[1] = new int[]{0,1,0,0};
        grid[2] = new int[]{0,0,0,0};
        grid[3] = new int[]{0,0,0,0};
        System.out.println(kuohao.uniquePathsWithObstacles(grid));

        grid = new int[5][5];
        grid[0] = new int[]{0,0,1,0,0};
        grid[1] = new int[]{0,1,0,0,0};
        grid[2] = new int[]{0,0,1,0,0};
        grid[3] = new int[]{0,0,0,1,0};
        grid[4] = new int[]{0,0,1,0,0};
        System.out.println(kuohao.uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        int x = obstacleGrid[0].length, y = obstacleGrid.length;
        int[][] totalArr = new int[y][x];
        totalArr[0][0] = 1;
        dp(totalArr, obstacleGrid, --x, --y);

        return totalArr[y][x];
    }

    private int dp(int[][] totalArr, int[][] obstacleGrid, int x, int y) {
        if(x<0 || y<0 || obstacleGrid[y][x] == 1){
            return 0;
        }
        if(obstacleGrid[y][x] != 1 && totalArr[y][x] != 0){
            return totalArr[y][x];
        }

        int totalX = 0, totalY = 0;
        if(x>0 && obstacleGrid[y][x-1] != 1){
            totalX = dp(totalArr, obstacleGrid, x-1, y);
        }
        if(y>0 && obstacleGrid[y-1][x] != 1){
            totalY = dp(totalArr, obstacleGrid, x, y-1);
        }

        totalArr[y][x] = totalX + totalY;
        return totalArr[y][x];
    }
}
