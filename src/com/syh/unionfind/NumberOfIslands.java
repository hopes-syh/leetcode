package com.syh.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-22
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class NumberOfIslands {

    public static void main(String args[])
    {
        NumberOfIslands cin = new NumberOfIslands();
        char[][] board = null;

        board = new char[4][5];
        board[0] = new char[]{'1', '1', '0', '1', '0'};
        board[1] = new char[]{'1', '1', '0', '1', '0'};
        board[2] = new char[]{'1', '1', '0', '0', '1'};
        board[3] = new char[]{'0', '0', '0', '1', '0'};
        System.out.println(cin.numIslands(board));
    }

    public int numIslands(char[][] grid) {
        if(grid.length <= 0){
            return 0;
        }

        int landNum = 0;
        int[][] group = new int[grid.length][grid[0].length];
        for(int y=0; y<grid.length; y++){
            for(int x=0; x<grid[y].length; x++){
                if(group[y][x] != 0 || grid[y][x] != '1'){
                    continue;
                }
                island(grid, group, y, x, ++landNum);
            }
        }

        return landNum;
    }

    private void island(char[][] grid, int[][] group, int y, int x, int landNum) {
        boolean island = grid[y][x] == '1';
        if(!island){
            group[y][x] = 0;
            return;
        }
        if(group[y][x] != 0){
            return;
        }

        group[y][x] = landNum;

        island(grid, group, y-1 >= 0 ? y-1 : 0, x, landNum);
        island(grid, group, y+1 <= grid.length-1 ? y+1 : grid.length-1, x, landNum);
        island(grid, group, y, x-1 >= 0 ? x-1 : 0, landNum);
        island(grid, group, y, x+1 <= grid[y].length-1 ? x+1 : grid[y].length-1, landNum);
    }
}
