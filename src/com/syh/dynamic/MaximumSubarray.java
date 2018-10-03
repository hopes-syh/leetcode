package com.syh.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-6-30
 * Time: 下午12:29
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 2, 3, -2, 4}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));

        /*int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a, a.length));*/
    }

    static int maxSubArray(int A[], int n) {
        if(n == 0) return 0;
        int sum = A[0];         // 以A[0]结束的连续子数组和最大值
        int maxResult = A[0];
        for(int i = 1; i < n; i++){
            sum = Math.max(A[i],A[i]+sum);      // 以A[i]结束的连续子数组和最大值
            if(maxResult < sum) maxResult = sum;
        }
        return maxResult;
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;

        int tmpmax = nums[0];
        int max = tmpmax;
        for(int i = 1; i <= length-1; i++){
            tmpmax = Math.max(tmpmax + nums[i], nums[i]);
            if(tmpmax > max){
                max = tmpmax;
            }
        }
        return max;
    }
}
