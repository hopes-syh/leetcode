package com.syh.backtracking;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-21
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations2_1 {

    public static void main(String[] args) {
        Permutations2_1 pw = new Permutations2_1();

//        System.out.println(pw.permuteUnique(new int[]{1}));
        System.out.println(pw.permuteUnique(new int[]{1, 1, 2}));
//        System.out.println(pw.permuteUnique(new int[]{1, 2, 2, 3}));
//        System.out.println(pw.permuteUnique(new int[]{2, 3, 6, 6, 7}));
//        System.out.println(pw.permuteUnique(new int[]{2, 3, 5}));
        System.out.println(pw.permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1}));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len<=0){
            return resultList;
        }

        Arrays.sort(nums);
        int[] passIndexs = new int[len];
        Map<String, List<Integer>> resultMap = new HashMap<String, List<Integer>>();
        dfs(resultMap, new ArrayList<Integer>(), nums, passIndexs);

        for(List<Integer> result1 : resultMap.values()){
            resultList.add(result1);
        }
        return resultList;
    }

    private Object[] dfs(Map<String, List<Integer>> resultMap, List<Integer> result, int[] nums, int[] passIndexs) {
        if(result.size() == nums.length){
            resultMap.put(String.valueOf(result), new ArrayList<Integer>(result));
            return new Object[]{result, passIndexs};
        }

        for(int i=0; i<nums.length; i++){
            if(passIndexs[i] == 1){
                continue;
            }

            if(i>0 && nums[i]==nums[i-1] && passIndexs[i-1] == 0){
                continue;
            }

            passIndexs[i] = 1;
            result.add(nums[i]);
            Object[] objects = dfs(resultMap, result, nums, passIndexs);

            result = (List<Integer>) objects[0];
            result = result.subList(0, result.size()-1);
            passIndexs = (int[]) objects[1];
            passIndexs[i] = 0;
        }

        return new Object[]{result, passIndexs};
    }

}
