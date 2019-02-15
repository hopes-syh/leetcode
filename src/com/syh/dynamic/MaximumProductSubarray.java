package com.syh.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-2-16
 * Time: 上午2:59
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();

        //System.out.println(mps.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(mps.maxProduct(new int[]{2,3,-2,4,2}));
        //System.out.println(mps.maxProduct(new int[]{2,3, 0,4,2}));
        //System.out.println(mps.maxProduct(new int[]{2,3,-2,4,-3}));
        //System.out.println(mps.maxProduct(new int[]{2,3,-2,4,-3,1,-1}));
        //System.out.println(mps.maxProduct(new int[]{-2,0,-1}));
        //System.out.println(mps.maxProduct(new int[]{0,1}));
        //System.out.println(mps.maxProduct(new int[]{1,2,0,10}));
        //System.out.println(mps.maxProduct(new int[]{1,2,0,0,0,3,4}));
        //System.out.println(mps.maxProduct(new int[]{1,2,0,0,0,1}));
        //System.out.println(mps.maxProduct(new int[]{3, -1, 4}));
        //System.out.println(mps.maxProduct(new int[]{-3, 1, -4}));
    }


    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0){
            return 0;
        }

        int max = nums[0], min = nums[0], result = nums[0];
        for(int i=1; i<len; i++){
            int tmpmax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmpmax * nums[i], min * nums[i]), nums[i]);
            if(max > result){
                result = max;
            }
        }

        return result;
    }


    public int maxProduct1(int[] nums) {
        int len = nums.length;
        if(len <= 0){
            return 0;
        }

        int maxIdx = 0;
        int max = nums[maxIdx], tmpMax = 0, all = nums[0];
        for(int i=1; i<len; i++){
            if (nums[i] == 0){
                max = max >= 0 ? max : 0;
                all = 0;
                continue;
            }

            all = all==0 ? nums[i] : all * nums[i];
            if(maxIdx == i-1){
                tmpMax = max * nums[i];
                if(tmpMax >= max){
                    maxIdx = i;
                }
            } else {
                tmpMax = max;
            }
            if(all >= max){
                maxIdx = i;
            }

            max = Math.max(max, Math.max(tmpMax, all));
        }

        return max;
    }
}
