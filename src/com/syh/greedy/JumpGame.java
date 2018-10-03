package com.syh.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-28
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2, 0}));
        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{0, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        if(len > 1  && nums[0] == 0){
            return false;
        }
        if(len == 1 && nums[0] == 0){
            return true;
        }

        boolean[] dp = new boolean[len];
        dp[0] = true;
        for(int i = 1; i < len; i++){

            for(int j=0; j<i; j++){
                if(dp[i]){
                    break;
                }
                dp[i] = dp[j] && (j + nums[j] >= i);
            }
        }

        return dp[len-1];
    }
}
