package com.syh.hashs;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-2-24
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board1 = new char[9][9];
        board1[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board1[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board1[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board1[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board1[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board1[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board1[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board1[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board1[8] = new char[]{'.','.','.','.','8','.','.','7','9'};

        System.out.println(isValidSudoku(board1));
    }

    public static boolean isValidSudoku(char[][] board) {
        //最外层循环，每次循环并非只是处理第i行，而是处理第i行、第i列以及第i个3x3的九宫格
        for(int i = 0; i < 9; i++){
            HashSet<Character> line = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                if('.' != board[i][j] && !line.add(board[i][j]))
                    return false;
                if('.' != board[j][i] && !col.add(board[j][i]))
                    return false;
                int m = i/3*3+j/3;
                int n = i%3*3+j%3;
                if('.' != board[m][n] && !cube.add(board[m][n]))
                    return false;
            }
        }
        return true;
    }
}
