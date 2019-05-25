package com.syh.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public static void main(String args[]){
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();

        System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 7, 8}));
    }

    public int longestConsecutive(int[] nums) {
        if(null == nums || nums.length <= 0){
            return 0;
        }

        int size = nums.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(size);
        Set<Integer> root = new HashSet<>(size);
        for (int num : nums) {
            union(root, map, num);
        }

        for(Integer num : root) {
            max = Math.max(max, find(map, num));
        }
        return max;
    }

    private int find(Map<Integer, Integer> map, int num) {
        int pre = num-1, next = num+1;
        int preSize = 0, nextSize = 0;

        while (map.containsKey(pre)){
            preSize++;
            pre = map.get(pre);
        }

        while (map.containsKey(next)){
            nextSize++;
            next++;
        }

        return preSize + nextSize + 1;
    }

    private void union(Set<Integer> root, Map<Integer, Integer> map, int num) {
        int pre = num-1, next = num+1;
        if(map.containsKey(pre)){
            map.put(num, pre);
        } else {
            map.put(num, null);
            root.add(num);
        }

        if(map.containsKey(next)){
            map.put(next, num);
            root.remove(next);
        }
    }
}
