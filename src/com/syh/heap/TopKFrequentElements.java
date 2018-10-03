package com.syh.heap;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-8-19
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements sum = new TopKFrequentElements();

        System.out.println(sum.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(sum.topKFrequent(new int[]{1, 0, -1, 0, -2, 2}, 2));
        System.out.println(sum.topKFrequent(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 2));
        System.out.println(sum.topKFrequent(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, 2));

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        PriorityQueue<Pair> pairsQueue = new PriorityQueue<Pair>(k+1, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count - o2.count;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        Pair pair;
        for(Integer key : map.keySet()){
            pair = new Pair(key, map.get(key));
            pairsQueue.offer(pair);

            if(pairsQueue.size() > k){
                pairsQueue.poll();
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        while (pairsQueue.size() > 0){
            result.add(pairsQueue.poll().num);
        }

        return result;
    }

    class Pair{
        int num;
        int count;
        public Pair(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
}
