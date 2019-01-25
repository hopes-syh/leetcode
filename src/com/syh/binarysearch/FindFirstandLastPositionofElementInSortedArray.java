package com.syh.binarysearch;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-26
 * Time: 上午6:34
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionofElementInSortedArray {

    public static void main(String[] args) {
        FindFirstandLastPositionofElementInSortedArray zzc = new FindFirstandLastPositionofElementInSortedArray();

        println(zzc.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        println(zzc.searchRange(new int[]{5, 7, 7, 8, 9, 10}, 8));
        println(zzc.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7));
        println(zzc.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        println(zzc.searchRange(new int[]{5, 7, 7, 7, 7, 10}, 7));
        println(zzc.searchRange(new int[]{7, 7, 7, 7, 7, 7}, 7));
        println(zzc.searchRange(new int[]{7, 7}, 7));
        println(zzc.searchRange(new int[]{7, 9}, 7));
        println(zzc.searchRange(new int[]{0,0,1,1,1,4,5,5}, 2));
    }

    private static void println(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for(int i:ints){
            sb.append(i).append(",");
        }

        System.out.println(sb.toString());
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int len = nums.length;
        if(len <= 0){
            return result;
        }
        if(nums[0] > target || nums[nums.length-1] < target){
            return result;
        }

        int first = 1;
        int preleft = 0, left = 0, aftleft = len;
        int preright = 0, right = 0, aftright = len;
        while (true){
            left = (preleft + aftleft) / 2;
            right = (preright + aftright) / 2;
            if(first == 1){
                first=0;
                left = left>0 ? left-1 : left;
            }

            if(result[0] == -1){
                if(nums[left] == target){
                    if(left == 0 || (left > 0 && nums[left-1]!=nums[left])){
                        result[0] = left;
                    }
                    else {
                        aftleft = left;
                    }
                }
                else if(nums[left] > target){
                    aftleft = left;
                }
                else if(nums[left] < target){
                    preleft = left;
                }
            }

            if(result[1] == -1){
                if(nums[right] == target){
                    if(right == len-1 || (right < len-1 && nums[right]!=nums[right+1])){
                        result[1] = right;
                    }
                    else{
                        preright = right;
                    }
                }
                else if(nums[right] > target){
                    aftright = right;
                }
                else if(nums[right] < target){
                    preright = right;
                }
            }

            if(result[0] != -1 && result[1] != -1){
                break;
            }
            if((result[0]==-1 && result[1]==-1)
                    && (aftleft-preleft <= 1 && nums[preleft] != target && nums[aftleft] != target)
                    && (aftright-preright <=1 && nums[preright] != target && nums[aftright] != target)){
                break;
            }
        }

        return result;
    }
}
