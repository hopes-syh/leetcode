package com.syh.twopointers;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/description/
 **/
public class SumClosest3 {

    public static void main(String[] args) {
        SumClosest3 kuohao = new SumClosest3();
        System.out.println(kuohao.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));  // --> 2
        System.out.println(kuohao.threeSumClosest(new int[]{-2, 3, 5, -2}, 3));  // --> 1
        System.out.println(kuohao.threeSumClosest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 13));
        System.out.println(kuohao.threeSumClosest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 16));
        System.out.println(kuohao.threeSumClosest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 22));
        System.out.println(kuohao.threeSumClosest(new int[]{0, 2, 1, -3}, 1));  // --> 0
        System.out.println(kuohao.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
        System.out.println(kuohao.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));  // --> -2
    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int ret = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; ++i){
            int beg = i + 1;
            int end = len - 1;
            while(beg < end){
                int tmp = nums[i] + nums[beg] + nums[end];
                int tmpDiff  = Math.abs(tmp - target);
                if(tmpDiff < diff){
                    ret = tmp;
                    diff = tmpDiff;
                }
                if(tmp < target)
                    beg++;
                else if(tmp > target)
                    end--;
                else
                    return target;
            }
        }
        return ret;
    }

    public int threeSumClosest2(int[] nums, int target){
        if(nums.length <= 2){
            return 0;
        }

        Arrays.sort(nums);
        int head = 0, mid = head+1, tail = nums.length-1;
        int sum = nums[head] + nums[mid] + nums[tail];
        int minInv = Math.abs(sum - target);
        while (true){
            if(head >= mid || mid >= tail || head >= tail){
                break;
            }

            int tmpSum;
            if(head+1 == mid && mid+1 == tail){
                tmpSum = nums[head] + nums[mid] + nums[tail];
                if(minInv > Math.abs(tmpSum - target)){
                    minInv = Math.abs(tmpSum - target);
                    sum = tmpSum;
                }
                break;
            }
            if(minInv == 0){
                return sum;
            }

            tmpSum = nums[head] + nums[mid] + nums[tail];
            if(minInv < Math.abs(tmpSum - target) && tmpSum - target >= 0){
                if((nums[head+1]+nums[head+2]) < (nums[head] + nums[mid])){
                    head++;
                    mid = head+1;
                } else {
                    tail--;
                    mid = head + 1;
                }
            }
            else if(minInv < Math.abs(tmpSum - target) && tmpSum - target < 0 && mid == tail-2){
                head++;
                mid = head+1;
            }
            else if(minInv > Math.abs(tmpSum - target)){
                sum = tmpSum;
                minInv = Math.abs(tmpSum - target);
                mid++;
                if(mid == tail){
                    head++;
                    mid = head+1;
                }
            }
            else {
                mid++;
            }
        }
        return sum;
    }

    public int threeSumClosest1(int[] nums, int target){
        if(nums.length <= 2){
            return 0;
        }

        Arrays.sort(nums);
        int head = 0, mid = head+1, tail = nums.length-1;
        int sum = nums[head] + nums[mid] + nums[tail];
        int minInv = Math.abs(sum - target);
        while (true){
            if(head >= mid || mid >= tail || head >= tail){
                break;
            }

            int tmpSum;
            if(head+1 == mid && mid+1 == tail){
                tmpSum = nums[head] + nums[mid] + nums[tail];
                if(minInv > Math.abs(tmpSum - target)){
                    minInv = Math.abs(tmpSum - target);
                    sum = tmpSum;
                }
                break;
            }
            if(minInv == 0){
                return sum;
            }

            if(mid < tail-1){
                tmpSum = nums[head] + nums[mid] + nums[tail-1];
                if(minInv < Math.abs(tmpSum - target) && tmpSum - target >= 0){
                    tail--;
                    mid = head+1;
                }
                else if(minInv < Math.abs(tmpSum - target) && tmpSum - target < 0){
                    head++;
                    mid = head+1;
                }
                else {
                    sum = tmpSum;
                    minInv = Math.abs(tmpSum - target);
                    mid++;
                }
            }

            if(head+1 < mid){
                tmpSum = nums[head+1] + nums[mid] + nums[tail];
                if(minInv < Math.abs(tmpSum - target) && tmpSum - target >= 0){
                    tail--;
                    mid = head+1;
                }
                else if(minInv < Math.abs(tmpSum - target) && tmpSum - target < 0){
                    head++;
                    mid = head+1;
                }
                else {
                    sum = tmpSum;
                    minInv = Math.abs(tmpSum - target);
                    head++;
                    mid = head+1;
                }
            }
        }

        return sum;
    }
}
