package com.syh.slidingwindow;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum num = new SlidingWindowMaximum();
        int[] nums = null;

        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 1)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 2)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 8)));

        nums = new int[]{3, 3, -3, -3, -3, 3, 3, 3};
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 1)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 2)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 3)));
        
        nums = new int[]{2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39};
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 1)));
        System.out.println(Arrays.toString(num.maxSlidingWindow(nums, 10)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k <= 1){
            return nums;
        }
        int size = nums.length;
        if(size <= 0){
            return nums;
        }

        int[] result = new int[size - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for(int i=0; i<size; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i-k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);

            if(i+1 >= k)
                result[i+1-k] = nums[deque.peekFirst()];
        }

        return result;
    }
}
