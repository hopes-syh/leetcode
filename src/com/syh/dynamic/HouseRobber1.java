package com.syh.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-7
 * Time: 下午1:01
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber1 {

    public static void main(String[] args) {

//        System.out.println(rob(new int[]{1,2,3,1}));       // 4
//        System.out.println(rob(new int[]{2,7,9,3,1}));     // 12
//        System.out.println(rob(new int[]{2,1,1,2}));       // 4
        System.out.println(rob(new int[]{2,3,7,9,8,6,2})); // 18
        System.out.println(rob(new int[]{2,7,6,7,6,6,9,6,2,1})); // 25
//        System.out.println(rob(new int[]{1,4,1}));               // 4
//        System.out.println(rob(new int[]{2,3,2}));               // 4
    }


    public static int rob(int[] nums) {
        int length = nums.length;
        if(length <= 0){
            return 0;
        }
        else if(length == 1){
            return nums[0];
        }


        int[] dp = new int[length];
        for(int i=0; i<length; i++){
            int s=0, f=0;
            if(i>=1){
                f = dp[i - 1];
            }
            else{
                f =  nums[i];
            }

            if(i>=2){
                s = dp[i - 2] + nums[i];
            } else {
                s = nums[i];
            }

            dp[i] = Math.max(f, s);
        }

        int max=0;
        for(int i:dp){
            max = Math.max(i, max);
        }
        return max;
    }
}
