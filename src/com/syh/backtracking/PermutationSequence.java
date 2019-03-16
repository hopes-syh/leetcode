package com.syh.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-17
 * Time: 上午12:32
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();

        System.out.println(ps.getPermutation(1, 1));
        System.out.println(ps.getPermutation(2, 1));
        System.out.println(ps.getPermutation(3, 2));
        System.out.println(ps.getPermutation(3, 3));
        System.out.println(ps.getPermutation(4, 9));
        System.out.println(ps.getPermutation(8, 31492));
        System.out.println(ps.getPermutation(9, 171669));
    }

    public String getPermutation(int n, int k) {
        if(k<=0 || n<=0){
            return null;
        }

        List<Integer> nums = new ArrayList<Integer>(n);
        for(int i=0; i<n; i++){
            nums.add(i+1);
        }
        List<Integer> result = new ArrayList<Integer>();
        result = dfs(result, nums, 0, n, k);

        StringBuilder sb = new StringBuilder(n);
        for(Integer item : result){
            sb.append(item);
        }
        return sb.toString();
    }

    public List<Integer> dfs(List<Integer> result, List<Integer> nums, int q, int n, int k){
        if(0==n){
            return result;
        }

        int psize = 1;
        for(int i=0; i<n; i++){
            if(i!=0){
                psize *= i;
            }
        }
        int idx = (k-1) / psize;
        int nk = k-((k-1)/psize)*psize;
        nk = nk==0 ? 1 : nk;

        int t = nums.get(idx);
        nums.remove(idx);
        result.add(t);
        dfs(result, nums, ++q, --n, nk);

        return result;
    }

}
