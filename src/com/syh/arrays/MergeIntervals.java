package com.syh.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-18
 * Time: 上午11:17
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervalList = null, resultList = null;

        intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(0, 4));
        resultList = mi.merge(intervalList);
        System.out.println(resultList);

        intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(2, 6));
        intervalList.add(new Interval(5, 7));
        intervalList.add(new Interval(8, 10));
        intervalList.add(new Interval(15, 18));
        resultList = mi.merge(intervalList);
        System.out.println(resultList);

        intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(4, 5));
        resultList = mi.merge(intervalList);
        System.out.println(resultList);

        intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(1, 6));
        intervalList.add(new Interval(1, 2));
        resultList = mi.merge(intervalList);
        System.out.println(resultList);
    }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultList = new ArrayList<Interval>();
        if(null == intervals || intervals.size() <= 0){
            return resultList;
        }


        PriorityQueue<Interval> intervalQueue = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        intervalQueue.addAll(intervals);

        Interval lastResult, mergeInterval;
        while (!intervalQueue.isEmpty()){
            mergeInterval = intervalQueue.poll();
            if(resultList.size() <= 0){
                resultList.add(mergeInterval);
            }
            else{
                lastResult = resultList.get(resultList.size()-1);

                if(lastResult.end >= mergeInterval.start && lastResult.end <= mergeInterval.end){
                    lastResult = new Interval(lastResult.start, mergeInterval.end);

                    resultList.remove(resultList.size()-1);
                    resultList.add(lastResult);
                }
                else if(lastResult.end < mergeInterval.start){
                    resultList.add(mergeInterval);
                }
            }
        }
        return resultList;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return String.format("[%s,%s]", start, end);
        }
    }
}
