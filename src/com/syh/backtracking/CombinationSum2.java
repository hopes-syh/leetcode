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
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        ///System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2, 2, 2, 2, 2}, 10));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        backTrace(res, list, candidates, target, target, 0);
        return res;
    }

    private static void backTrace(List<List<Integer>> res, List<Integer> list, int[] candidates,
                                      int target, Integer remain, int start) {
        if(remain < 0)
            return ;
        if(remain == 0){
            res.add(new ArrayList<Integer>(list));
        }
        else{
            for(int i=start;i<candidates.length;i++){
                if(i > start && candidates[i]==candidates[i-1])
                    continue;
                list.add(candidates[i]);
                backTrace(res, list, candidates, target, remain-candidates[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
