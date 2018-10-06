package com.syh.twopointers;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-6
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater zzc = new ContainerWithMostWater();
        System.out.println(zzc.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(zzc.maxArea(new int[]{10,9,8,7,6,5,4,3,2,1}));
    }

    public int maxArea(int[] height) {
        if(height.length <= 0){
            return 0;
        }

        int maxArea = 0, head = 0, tail = height.length-1;
        while (true){
            int tmpArea = (tail-head) * Math.min(height[head], height[tail]);
            maxArea = Math.max(tmpArea, maxArea);

            if(height[head] > height[tail]){
                tail--;
            }
            else {
                head++;
            }
            if(head >= tail){
                break;
            }
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        if(height.length <= 0){
            return 0;
        }

        int maxArea = 0, head = 0, tail = 0;
        for(head=0; head<height.length; head++){

            for(tail = height.length-1; tail>head; tail--){
                int hMax = (tail-head) * Math.min(height[head], height[tail]);
                maxArea = hMax > maxArea ? hMax : maxArea;
            }
        }
        return maxArea;
    }
}
