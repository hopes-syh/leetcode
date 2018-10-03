package com.syh.bitmanipulation;

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
public class Subsets {

    public static void main(String[] args) {
        Subsets sub = new Subsets();
        System.out.println(sub.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        int lenth = nums.length;

        int total = 1 << lenth;

        for(int i=0; i<total; i++){
            List<Integer> temp = new ArrayList<Integer>();

            for(int j=0; j<lenth; j++){
                if( ((1<<j)&i) != 0){
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
