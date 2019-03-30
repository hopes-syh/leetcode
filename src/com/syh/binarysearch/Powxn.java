package com.syh.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-31
 * Time: 上午1:55
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Powxn {

    public static void main(String[] args) {
        Powxn di = new Powxn();

//        System.out.println(di.myPow(2.00000, 10));
//        System.out.println(di.myPow(2.10000, 3));
//        System.out.println(di.myPow(2.00000, -2));
//        System.out.println(di.myPow(1.00000, Integer.MIN_VALUE));
        System.out.println(di.myPow(2.00000, Integer.MIN_VALUE));
        System.out.println(di.myPow(-1.00000, Integer.MIN_VALUE));
//        System.out.println(di.myPow(-99.99000, Integer.MIN_VALUE));
//        System.out.println(di.myPow(-99.99000, Integer.MAX_VALUE));
//        System.out.println(di.myPow(99.99000, Integer.MIN_VALUE));
//        System.out.println(di.myPow(99.99000, Integer.MAX_VALUE));
    }

    public double myPow(double x, int n) {
        double result = 0.00;
        if(x==0){
            return result;
        }
        if(n==0){
            return 1.00;
        }
        if(n < 0){
            x = 1/x;
            if(n == Integer.MIN_VALUE)
                n = Integer.MAX_VALUE-1;
            else
                n = -n;
        }

        Map<String, Double> map = new HashMap<String, Double>();
        result = helper(x, n, map);
        return result;
    }

    public double helper(double x, int n, Map<String, Double> map){
        double result = 0.00;

        String key = x+"_"+n;
        if(n==1){
            return x;
        }
        if(n==0){
            return 1.00;
        }
        if(map.containsKey(key)){
            return map.get(key);
        }

        // 如果n为奇数
        int isJ = n%2;
        if(isJ == 1)
            result = helper(x, n/2, map) * helper(x, n/2, map) * x;
        else
            result = helper(x, n/2, map) * helper(x, n/2, map);

        map.put(key, result);
        return result;
    }
}
