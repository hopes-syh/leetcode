package com.syh.arrays;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-9
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();

        System.out.println(bt.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bt.maxProfit(new int[]{1,7,5,3,6,4}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,1,6,4}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,4,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,2,4,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,3,4,2,5,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=1){
            return 0;
        }

        TreeMap<Integer, List<Integer>> minMap = new TreeMap<Integer, List<Integer>>();
        int diff = 0, min = Integer.MAX_VALUE;

        for(int i=0; i<len; i++){

            if(i==0 || (prices[i] < prices[i-1] && prices[i] < min)){
                min = prices[i];
                if(!minMap.containsKey(min)){
                    minMap.put(min, new ArrayList<Integer>());
                }
                if(minMap.size()>2){
                    minMap.remove(minMap.lastKey());
                }
            }
            else {
                for(Integer minVal : minMap.keySet()){
                    List<Integer> maxList = minMap.get(minVal);
                    if(minVal > prices[i]){
                        continue;
                    }

                    if(maxList.size()<=0){
                        maxList.add(prices[i]);
                        diff = diff < prices[i]-minVal ? prices[i]-minVal : diff;
                    }
                    else if(maxList.get(maxList.size()-1) < prices[i]){
                        maxList.add(prices[i]);
                        diff = diff < prices[i]-minVal ? prices[i]-minVal : diff;
                    }
                }
            }
        }

        return diff;
    }
}
