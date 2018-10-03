package com.syh.segmenttree;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-2
 * Time: 下午2:33
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        NumArray num = new NumArray(new int[]{7, 2, 4, 5, 1, 8, 3, 9, 6});

        System.out.println(num.sumRange(1, 7));
        num.update(2, 1);
        System.out.println(num.sumRange(1, 7));
    }

    static class NumArray {
        SegmentTreeNode root;
        int size = 0;

        class SegmentTreeNode{
            int sum = 0, lc = 0, rc = 0;
            SegmentTreeNode left = null, right = null;

            SegmentTreeNode(int head, int tail){
                this.lc = head;
                this.rc = tail;
            }
        }

        public NumArray(int[] nums) {
            root = buildSegmentTree(nums, 0, nums.length-1);
            size = nums.length;
        }

        private SegmentTreeNode buildSegmentTree(int[] nums, int head, int tail) {
            if(head > tail){
                return null;
            }

            SegmentTreeNode node = new SegmentTreeNode(head, tail);
            if(head == tail){
                node.sum = nums[head];
                return node;
            }

            int mid = (head + tail) >> 1;
            node.left = buildSegmentTree(nums, head, mid);
            node.right = buildSegmentTree(nums, mid+1, tail);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }

        public void update(int i, int val) {
            if(i<0 || i>=size) return;
            doUpdate(root, i, val);
        }

        private void doUpdate(SegmentTreeNode node, int i, int val) {
            if(node == null){
                return;
            }
            if(node.lc == node.rc && node.lc == i){
                node.sum = val;
                return;
            }

            int mid = (node.lc + node.rc) >> 1;
            if(i >= node.lc && i <= mid){
                doUpdate(node.left, i, val);
            }
            else {
                doUpdate(node.right, i, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }

        public int sumRange(int i, int j) {
            if(i>j || i<0 || j>size-1){
                return -1;
            }

            return querySum(root, i, j);
        }

        private int querySum(SegmentTreeNode node, int i, int j) {
            if(i > j) {
                return 0;
            }
            if(node.lc == i && node.rc == j){
                return node.sum;
            }

            int mid = (node.lc + node.rc) >> 1;
            if(i > mid){
                return querySum(node.right, i, j);
            }
            else if (j < mid){
                return querySum(node.left, i, j);
            }
            else{
                return querySum(node.left, i, mid) + querySum(node.right, mid + 1, j);
            }
        }
    }
}
