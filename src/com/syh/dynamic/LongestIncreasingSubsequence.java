package com.syh.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-29
 * Time: 上午2:07
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lis.lengthOfLIS(new int[]{10,9,4,5,3,4,7,101,18}));
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,18,3,11,15}));
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int max = 0;
        if(size <= 0){
            return max;
        }

        int[] result = new int[size];
        for(int i=0; i<size; i++){
            int tmpmax = 0;

            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    tmpmax = Math.max(tmpmax, result[j]);
                }
            }

            result[i] = tmpmax + 1;
            max = Math.max(max, result[i]);
        }
        return max;
    }

}
