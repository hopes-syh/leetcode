package com.syh.binarysearch;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-1
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray2 s = new SearchInRotatedSortedArray2();

        System.out.println(s.search(new int[]{2,5,6,0,0,0,1,2}, 0));
        System.out.println(s.search(new int[]{2,5,6,0,0,0,1,2}, 3));
        System.out.println(s.search(new int[]{5,6,0,0,0,0,1,2}, 3));
        System.out.println(s.search(new int[]{0,0,6,0,0,0,0,0}, 6));
        System.out.println(s.search(new int[]{0,0,6,9,9,9,0,0}, 6));
    }

    public boolean search(int[] nums, int target) {
        if(nums.length <= 0){
            return false;
        }

        int len = nums.length, l=0, m=len/2, r=len-1;
        return doSearch(nums, target, l, m) || doSearch(nums, target, m, r);
    }

    private boolean doSearch(int[] nums, int target, int l, int r) {
        int left = nums[l], right = nums[r];
        if(target == left)
            return true;
        if(target == right)
            return true;
        if(Math.abs(l-r)<=1){
            return false;
        }

        int m = (l+r)/2;
        if(left == right){
            return doSearch(nums, target, l, m) || doSearch(nums, target, m, r);
        }
        if(left < right){
            if(left<target && target<right){
                return doSearch(nums, target, l, m) || doSearch(nums, target, m, r);
            }
            if(target<left || right<target){
                return false;
            }
        }
        if(right < left){
            return doSearch(nums, target, l, m) || doSearch(nums, target, m, r);
        }
        return false;
    }

}
