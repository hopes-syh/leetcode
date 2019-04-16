package com.syh.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();

        System.out.println(k.findKthLargest(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {    
        if(nums == null || nums.length <= 0){
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i=0; i<nums.length; i++){
            queue.add(nums[i]);
            if(queue.size() >= k+1)
                queue.poll();
        }

        return queue.poll();
    }
}
