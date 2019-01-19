package com.syh.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-19
 * Time: 上午3:44
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/triangle/
 */
public class Triangle {

    public static void main(String[] args) {
        Triangle s = new Triangle();

        List<List<Integer>> tl = new ArrayList<List<Integer>>();
        List<Integer> l0 = new ArrayList<Integer>(),
                l1 = new ArrayList<Integer>(),
                l2 = new ArrayList<Integer>(),
                l3 = new ArrayList<Integer>();

        l0.add(2);
        l1.add(3);l1.add(4);
        l2.add(6);l2.add(5);l2.add(7);
        l3.add(4);l3.add(9);l3.add(8);l3.add(3);
        tl.add(l0);tl.add(l1);tl.add(l2);tl.add(l3);
        System.out.println(s.minimumTotal(tl));
    }

    /**
     * 动态规划公式：d[i][j] = min(d[i-1][j-1], d[i-1][j]) + a[j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] totals = new int[triangle.size()];
        for(int i=0; i<totals.length; i++){
            totals[i] = Integer.MAX_VALUE;
        }

        List<Integer> ll = null;
        for(int i=0; i<triangle.size(); i++){
            ll = triangle.get(i);
            int pre = Integer.MAX_VALUE;

            for(int j=0; j<ll.size(); j++){
                int left = j-1<0 ? j : j-1;
                int right = j;
                int tmpPre = totals[right];

                int minTotal = Math.min(pre == Integer.MAX_VALUE ? totals[left] : pre, totals[right]);
                totals[j] = (Integer.MAX_VALUE == minTotal ? 0 : minTotal)
                        + ll.get(right);
                pre = tmpPre;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<totals.length; i++){
            min = Math.min(min, totals[i] );
        }
        return min;
    }
}
