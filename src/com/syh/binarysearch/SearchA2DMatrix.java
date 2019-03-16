package com.syh.binarysearch;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-17
 * Time: 上午3:33
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        SearchA2DMatrix ps = new SearchA2DMatrix();
        int[][] nums;

        nums = new int[3][4];
        int[] num1 = new int[]{1,   3,  5,  7};
        int[] num2 = new int[]{10, 11, 16, 20};
        int[] num3 = new int[]{23, 30, 34, 50};
        nums[0]=num1; nums[1]=num2; nums[2]=num3;

//        System.out.println(ps.searchMatrix(nums, 3));
//        System.out.println(ps.searchMatrix(nums, 13));
        System.out.println(ps.searchMatrix(nums, 24));


//        nums = new int[1][2];
//        nums[0] = new int[]{1, 3};
//        System.out.println(ps.searchMatrix(nums, 3));

//        nums = new int[2][1];
//        nums[0] = new int[]{1};
//        nums[1] = new int[]{3};
//        System.out.println(ps.searchMatrix(nums, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int ysize = matrix.length-1;
        if(ysize < 0){
            return false;
        }
        int xsize = matrix[0].length-1;
        if(xsize < 0){
            return false;
        }
        if(target < matrix[0][0] || target > matrix[ysize][xsize]){
            return false;
        }

        int row = Integer.MIN_VALUE;
        int up = 0, down = ysize;
        int ymid = (up+down)/2;
        while(true){
            if(matrix[ymid][0] == target || matrix[up][0] == target || matrix[down][0] == target)
                return true;

            if((ymid == ysize && matrix[ymid][0] < target)
                    ||(matrix[ymid][0] < target && target < matrix[ymid+1][0])){
                row = ymid;
                break;
            }

            if(matrix[ymid][0] > target){
                down = ymid;
                ymid = (up+down)/2;
                ymid = down==ymid ? up : ymid;
            }
            else if(matrix[ymid][0] < target){
                up = ymid;
                ymid = (up+down)/2;
                ymid = up==ymid ? down : ymid;
            }
            if(up == down && matrix[down][0] != target){
                return false;
            }
        }

        int l = 0, r = xsize, xmid = (l+r)/2;
        while (true){
            if(matrix[row][xmid] == target || matrix[row][l] == target || matrix[row][r] == target)
                return true;
            if(xmid == xsize && matrix[row][xmid] < target)
                return false;
            if((l==xmid || r==xmid) && (l+1==r || l==r) && (matrix[row][l] != target && matrix[row][r] != target))
                return false;

            if(matrix[row][xmid] > target){
                r = xmid;
                xmid = (l+r)/2;
            }
            else if(matrix[row][xmid] < target){
                l = xmid;
                xmid = (l+r)/2;
            }
        }
    }
}
