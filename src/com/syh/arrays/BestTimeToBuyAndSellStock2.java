package com.syh.arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-9
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bt = new BestTimeToBuyAndSellStock2();

        System.out.println(bt.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bt.maxProfit(new int[]{1,7,5,3,6,4}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,1,6,4}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,4,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,3,5,2,4,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,3,4,2,5,6,1}));
        System.out.println(bt.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(bt.maxProfit(new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=1){
            return 0;
        }

        int maxProfit = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){

            if(prices[i] < max){
                maxProfit += max-min;
                max = Integer.MIN_VALUE;
                min = prices[i];
            }
            else {
                min = Math.min(prices[i], min);
                max = Math.max(prices[i], max);
            }
        }

        if(max > min){
            maxProfit += max-min;
        }

        return maxProfit;
    }
}
