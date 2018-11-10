package com.syh.arrays;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-10
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] value;

//        value = new int[]{1,2,3};
//        np.nextPermutation(value);
//        System.out.println(value);
//
        value = new int[]{1,3,2};
        np.nextPermutation(value);
        System.out.println(value);

//        value = new int[]{2,3,1};
//        np.nextPermutation(value);
//        System.out.println(value);

//        value = new int[]{2,3,1};
//        np.nextPermutation(value);
//        System.out.println(value);
    }

    public void nextPermutation(int[] nums) {

        int numsIndex = nums.length-1;
        while (numsIndex>0 && nums[numsIndex] <= nums[numsIndex-1]){
            numsIndex--;
        }

        if(numsIndex == 0){
            Arrays.sort(nums);
            return ;
        }
        else {
            int minNum = nums[numsIndex - 1];
            for(int i=nums.length-1; i>numsIndex-1; i--){
                if(nums[i] > minNum){
                    int tmp = nums[i];
                    nums[i] = nums[numsIndex-1];
                    nums[numsIndex-1] = tmp;
                    break;
                }
            }
            Arrays.sort(nums, numsIndex, nums.length);
        }

    }
}
