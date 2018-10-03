package com.syh.arrays;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-8-12
 * Time: 下午8:33
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/4sum/description/
 * https://leetcode-cn.com/problems/3sum/description/
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class KSum {
    public static void main(String[] args) {
        KSum sum = new KSum();

       // System.out.println(sum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        // System.out.println(sum.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(sum.fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));


        // System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum(nums, 4, target);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return kSum(nums, 3, 0);
    }

    /*public int[] twoSum(int[] nums, int target) {
        return kSum(nums, 2, 0);
    }*/

    public List<List<Integer>> kSum(int[] nums, int limit, int target){
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(null == nums || nums.length <= 0){
            return resultList;
        }

        // 排序
        Arrays.sort(nums);

        Map<String, List<Integer>> resultMap = new HashMap<String, List<Integer>>();
        int sum = Integer.MIN_VALUE;
        List<Integer> result = null;
        for(int i=0, len=nums.length; i<len; i++){
            if(i > len - limit){
                break;
            }

            result = new ArrayList<Integer>(limit);
            sum = nums[i];
            result.add(nums[i]);
            doKSum(nums, sum, result, resultMap, i + 1, target, limit);

        }

        return new ArrayList<List<Integer>>(resultMap.values());
    }

    private int doKSum(int[] nums, int sum, List<Integer> result, Map<String, List<Integer>> resultMap,
                       int start, int target, int limit) {
        if(result.size() == limit){
            return sum;
        }

        for(int i=start, len=nums.length; i<len; i++){
            sum += nums[i];
            result.add(nums[i]);

            if(sum < target || result.size() < limit){
                sum = doKSum(nums, sum, result, resultMap, i+1, target, limit);
            }
            else if(sum > target){
                sum = doKSum(nums, sum, result, resultMap, i+1, target, limit);
            }

            if(result.size() == limit && sum == target){
                resultMap.put(Arrays.toString(result.toArray()), new ArrayList<Integer>(result));
            }

            sum -= result.get(result.size() - 1);
            result.remove(result.size() - 1);
        }

        return sum;
    }
}
