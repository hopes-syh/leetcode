package com.syh.backtracking;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-17
 * Time: 上午6:58
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = null;

        board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','C','S'};
        board[2] = new char[]{'A','D','E','E'};

        System.out.println(ws.exist(board, "ABCCED")); // true
        System.out.println(ws.exist(board, "SEE"));    // true
        System.out.println(ws.exist(board, "ABCB"));   // false
        System.out.println(ws.exist(board, "FCCFDA")); // false

        board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','E','S'};
        board[2] = new char[]{'A','D','E','E'};

        System.out.println(ws.exist(board, "ABCESEEEFS")); // true
    }

    public boolean exist(char[][] board, String word) {
        if(null == word || "".equals(word)){
            return false;
        }
        if(board.length<0 || board[0].length<0){
            return false;
        }
        int ysize = board.length, xsize = board[0].length;

        int[][] record = null;
        boolean exist = false;
        for(int y=0; y<ysize; y++){
            for(int x=0; x<xsize; x++){
                if(word.charAt(0) != board[y][x])
                    continue;

                record = new int[ysize][xsize];
                record[y][x] = 1;
                exist = exist || dfs(board, x, y, word, 1, record);
                if(exist){
                    return exist;
                }
            }
        }
        return exist;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int widx, int[][] record) {
        if(widx == word.length()){
            return true;
        }
        int ysize = board.length-1, xsize = board[0].length-1;

        boolean exist = false;
        int xl = x-1, xr = x+1, yu = y-1, yd = y+1;
        if(!exist && xl>=0){
            if(record[y][xl] == 1){
                exist = false;
            }
            else {
                if(board[y][xl] == word.charAt(widx)){
                    record[y][xl] = 1;
                    exist = exist || dfs(board, xl, y, word, widx+1, record);
                    if(!exist) record[y][xl] = 0;
                }
            }
        }
        if(!exist && xr<=xsize){
            if(record[y][xr] == 1){
                exist = false;
            }
            else{
                if(board[y][xr] == word.charAt(widx)){
                    record[y][xr] = 1;
                    exist = exist || dfs(board, xr, y, word, widx+1, record);
                    if(!exist) record[y][xr] = 0;
                }
            }
        }
        if(!exist && yu>=0){
            if(record[yu][x] == 1){
                exist = false;
            }
            else {
                if(board[yu][x] == word.charAt(widx)){
                    record[yu][x] = 1;
                    exist = exist || dfs(board, x, yu, word, widx+1, record);
                    if(!exist) record[yu][x] = 0;
                }
            }
        }
        if(!exist && yd<=ysize){
            if(record[yd][x] == 1){
                exist = false;
            }
            else {
                if(board[yd][x] == word.charAt(widx)){
                    record[yd][x] = 1;
                    exist = exist || dfs(board, x, yd, word, widx+1, record);
                    if(!exist) record[yd][x] = 0;
                }
            }
        }

        return exist;
    }
}
