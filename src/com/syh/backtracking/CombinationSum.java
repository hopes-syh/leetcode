package com.syh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-14
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/combination-sum
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrace(res,list,candidates,target,target,0);
        return res;
    }

    private static void backTrace(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int remain, int start) {
        if(remain < 0){
            return;
        }
        if(remain == 0){
            res.add(new ArrayList<Integer>(list));
        }
        else{
            for(int i=start, size=candidates.length; i<size; i++){
                list.add(candidates[i]);
                backTrace(res, list, candidates, target, remain-candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
