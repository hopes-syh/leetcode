package com.syh.binarysearch;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-1
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(s.search(new int[]{3,4,5,6,7,0,1,2}, 0));
//        System.out.println(s.search(new int[]{3,4,5,6,7,0,1,2}, 4));
//        System.out.println(s.search(new int[]{5,6,7,0,1,2,3,4}, 0));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 1));
    }

    public int search(int[] nums, int target) {
        if(nums.length <= 0){
            return -1;
        }

        int len = nums.length, l=0, m=len/2, r=len-1;
        while (true){
            int left = nums[l], mid = nums[m], right = nums[r];
            if(target == mid)
                return m;
            if(target == left)
                return l;
            if(target == right)
                return r;
            if(Math.abs(m-l)<=1 && Math.abs(m-r)<=1){
                return -1;
            }

            // 左边顺序
            if(left<mid){
                if(left<target && target<mid){
                    r = m;
                    m = (l+r)/2;
                    continue;
                }
                else{
                    l = m;
                    m = (l+r)/2;
                    continue;
                }
            }
            // 右边顺序
            if(mid<right){
                if(mid<target && target<right){
                    l = m;
                    m = (l+r)/2;
                    continue;
                }
                else{
                    r = m;
                    m = (l+r)/2;
                    continue;
                }
            }
        }
    }
}
