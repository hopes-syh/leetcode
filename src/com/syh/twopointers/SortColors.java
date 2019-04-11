package com.syh.twopointers;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-4-8
 * Time: 上午3:15
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = null;

        nums = new int[]{2,0,2,1,1,0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,0,1,1,2,2

        nums = new int[]{2,2,2,1,1,0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,1,1,2,2,2

        nums = new int[]{2,2,0,1,2,1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,1,1,2,2,2

        nums = new int[]{2,2,0,1,0,1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,0,1,1,2,2

        nums = new int[]{1,2,0,1,2,1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,1,1,1,2,2

        nums = new int[]{1,1,2,0,2,1,0,0,2,2};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // [0,0,0,1,1,1,2,2,2,2]
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return ;
        }

        int f0 = len-1, f1=len-1, f2=len-1;
        for(int i=0; i<len; i++){
            if(nums[i] == 0) continue;

            if(i==f1 || i==f2) return;

            for(int j = f2; j>i; j--){
                if(nums[i] > nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;

                    if(nums[j] == 2){
                        f2 = j;
                        f1 = j-1;
                    }
                    break;
                }
            }

            if(nums[i] == 0) continue;

            for(int j=f1; j>i; j--){
                if(nums[i] > nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;

                    break;
                }
            }
        }
    }
}
