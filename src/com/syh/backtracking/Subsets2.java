package com.syh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-1
 * Time: 下午1:55
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets2 {

    public static void main(String[] args) {
        Subsets2 sub = new Subsets2();
//        System.out.println(sub.subsetsWithDup(new int[]{}));
//        System.out.println(sub.subsetsWithDup(new int[]{1}));
        System.out.println(sub.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(sub.subsetsWithDup(new int[]{1, 2, 2, 2, 3}));
        System.out.println(sub.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null){
            return result;
        }
        result.add(new ArrayList<Integer>());
        int len = nums.length;
        if(len <= 0){
            return result;
        }
        Arrays.sort(nums);

        List<Integer> list = null;
        dfs(result, list, nums, 0, len);
        return result;
    }

    private List<Integer> dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int idx, int len) {
        if(idx >= len){
            return list;
        }
        if(null == list){
            list = new ArrayList<Integer>();
        }

        int pre = Integer.MIN_VALUE;
        for(int i=idx; i<len; i++){
            if(pre == nums[i])
                continue;
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));

            list = dfs(result, list, nums, i+1, len);
            pre = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        return list;
    }
}
