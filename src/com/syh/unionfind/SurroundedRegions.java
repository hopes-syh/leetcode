package com.syh.unionfind;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-22
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 */
public class SurroundedRegions {

    public static void main(String args[])
    {
        SurroundedRegions cin = new SurroundedRegions();
        char[][] board = null;

        board = new char[4][4];
        board[0] = new char[]{'O', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};
        cin.solve(board);
        System.out.println(board);
    }

    public void solve(char[][] board) {
        if(board.length <= 0){
            return;
        }
        for (int i=0; i<board[0].length; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[board.length-1][i] == 'O'){
                dfs(board, board.length-1, i);
            }
        }

        for(int i=0; i<board.length; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][board[0].length-1] == 'O'){
                dfs(board, i, board[0].length-1);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == '+'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int y, int x) {
        if(board[y][x] == 'X' || board[y][x] == '+'){
            return;
        }
        if(board[y][x] == 'O'){
            board[y][x] = '+';
        }

        dfs(board, y-1 >= 0 ? y-1 : 0,                           x);
        dfs(board, y+1 <= board.length-1 ? y+1 : board.length-1, x);
        dfs(board, y, x-1 >= 0 ? x-1 : 0);
        dfs(board, y, x+1 <= board[y].length-1 ? x+1 : board[y].length-1);
    }
}
