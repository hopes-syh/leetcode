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
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();

        System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(sum.threeSum(new int[]{1, 0, -1, 0, -2, 2}));
        System.out.println(sum.threeSum(new int[]{-3,-2,-1,0,0,1,2,3}));
        System.out.println(sum.threeSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}));


        // System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        Arrays.sort(nums);

        int a, b, sum, target = 0;
        for(int j=0; j<nums.length-2; j++){
            a = j+1;
            b = nums.length - 1;

            while (a<b){
                sum = nums[j] + nums[a] + nums[b];
                if(sum == target){
                    List<Integer> tmpResult = new ArrayList<Integer>();
                    tmpResult.add(nums[j]);
                    tmpResult.add(nums[a]);
                    tmpResult.add(nums[b]);
                    result.put(tmpResult.toString(), tmpResult);

                    b -= 1;
                    a += 1;
                }
                else if(sum > target){
                    b -= 1;
                }
                else if(sum < target){
                    a += 1;
                }
            }

            while (nums[j] == nums[j+1] && j<nums.length-2){
                j++;
            }
        }

        return new ArrayList<List<Integer>>(result.values());
    }
}
