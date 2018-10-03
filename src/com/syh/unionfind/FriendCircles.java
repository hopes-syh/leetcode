package com.syh.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-22
 * Time: 下午8:31
 * To change this template use File | Settings | File Templates.
 */
public class FriendCircles {
    public static void main(String args[])
    {
        FriendCircles cin = new FriendCircles();
        int[][] board = null;

        board = new int[4][4];
        board[0] = new int[]{1,1,0,0};
        board[1] = new int[]{1,1,1,0};
        board[2] = new int[]{0,1,1,1};
        board[3] = new int[]{0,0,1,1};
        System.out.println(cin.findCircleNum(board));
    }

    public int findCircleNum(int[][] M) {
        if(M.length <= 0){
            return 0;
        }

        int[] pre = new int[M.length];
        for(int i=0; i<M.length; i++){
            pre[i] = i;
        }
        int group = M.length;
        for(int y=0; y<M.length; y++){
            for(int x=0; x<M[y].length; x++){
                if(y!=x && M[y][x]==1){
                    int x1 = find(y, pre);
                    int x2 = find(x, pre);
                    if(x1 != x2){
                        pre[x1] = x2;
                        group--;
                    }
                }
            }
        }

        return group;
    }

    private int find(int x, int[] pre) {
        if(pre[x] == x){
            return x;
        }

        pre[x] = find(pre[x], pre);
        return pre[x];
    }
}
