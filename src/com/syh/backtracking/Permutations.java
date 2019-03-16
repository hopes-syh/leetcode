package com.syh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-21
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
//        System.out.println(permute(new int[]{1}));
//        System.out.println(permute(new int[]{1, 2}));
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1, 2, 3, 4}));
//        System.out.println(permute(new int[]{2, 3, 6, 7}));
//        System.out.println(permute(new int[]{2, 3, 5}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length <= 1){
            result.add(nums[0]);
            results.add(result);
            return results;
        }


        for(int i=0, len=nums.length; i<len; i++){
            result = new ArrayList<Integer>();
            result.add(nums[i]);
            doPermute(results, result, nums);
        }
        return results;
    }

    public static List<Integer> doPermute(List<List<Integer>> results, List<Integer> result, int[] nums){
        if(result.size() == nums.length){
            results.add(new ArrayList<Integer>(result));
            return result;
        }

        for(int j=0; j < nums.length; j++){
            if(result.contains(nums[j])){
                continue;
            }
            result.add(nums[j]);
            result = doPermute(results, result, nums);

            if(result.size() >= 2){
                result = result.subList(0, result.size()-1);
            }
        }
        return result;
    }
}
