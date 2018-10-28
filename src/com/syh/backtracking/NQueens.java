package com.syh.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-28
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 */
public class NQueens {
    public static void main(String[] args) {
        NQueens queens = new NQueens();
        // System.out.println(queens.solveNQueens(4));
        System.out.println(queens.solveNQueens(5));
        // System.out.println(queens.solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<=0){
            return result;
        }

        List<List<Queen>> resultList = new ArrayList<List<Queen>>();
        List<Queen> queenList;
        for(int x=1; x<=n; x++){
            queenList = new ArrayList<Queen>();
            dfs(resultList, queenList, n, x, 1);
            if(queenList.size() == n){
                resultList.add(queenList);
            }
        }

        StringBuilder orgSb = new StringBuilder();
        for(int i=0; i<n; i++){
            orgSb.append(".");
        }

        ArrayList<String> stringList;
        for(List<Queen> queenList1 : resultList){
            stringList = new ArrayList<String>();
            for(Queen queen : queenList1){
                stringList.add(orgSb.substring(0, queen.x-1) + "Q" + orgSb.substring(queen.x, n));
            }
            result.add(stringList);
        }
        return result;
    }

    private void dfs(List<List<Queen>> resultList, List<Queen> queenList, int n, int x, int y) {
        if(y>n || x>n ){
            return;
        }

        boolean isAdd = false;
        if(queenList.size() == 0){
            queenList.add(new Queen(x, y));
            isAdd = true;
        }
        else{
            int shouldAddSize = 0;
            for(Queen queen : queenList){
                if(queen.x != x && queen.y != y
                        && Math.abs(x-queen.x) != Math.abs(y-queen.y)){
                    ++shouldAddSize;
                }
                else {
                    break;
                }
            }
            if(shouldAddSize == queenList.size()){
                queenList.add(new Queen(x, y));
                isAdd = true;
            }
        }

        dfs(resultList, queenList, n, isAdd ? 1 : x+1, isAdd ? y+1 : y);
        if(queenList.size()!=n && queenList.size()>0 && queenList.get(queenList.size() - 1).y != y){
            Queen lastQueen = queenList.get(queenList.size()-1);
            queenList.remove(queenList.size()-1);
            if(queenList.size() != 0){
                dfs(resultList, queenList, n, lastQueen.x+1, lastQueen.y);
            }
        }
        else if(queenList.size()==n){
            resultList.add(new ArrayList<Queen>(queenList));
            Queen lastQueen = queenList.get(queenList.size()-1);
            queenList.remove(queenList.size()-1);
            if(queenList.size() != 0){
                dfs(resultList, queenList, n, lastQueen.x+1, lastQueen.y);
            }
        }
    }

    class Queen{
        int x, y;

        public Queen(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return String.format("x=%s, y=%s", x, y);
        }
    }
}
