package com.syh.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-25
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 */
public class UniqueBinarySearchTrees2 {


    public static void main(String[] args) {
        UniqueBinarySearchTrees2 st = new UniqueBinarySearchTrees2();

        System.out.println(st.generateTrees(2));
        System.out.println(st.generateTrees(3));
        System.out.println(st.generateTrees(4));
        System.out.println(st.generateTrees(5));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        if(n<=0){
            return treeNodeList;
        }

        int[] indexs = new int[n];
        for(int i=1; i<=n; i++){
            indexs[i] = i;
        }
        for(int i=1; i<=n; i++){
            int[] left = Arrays.copyOfRange(indexs, 0, i);
            int[] right = Arrays.copyOfRange(indexs, i, n);
            generateTrees(treeNodeList, i, left, right);
        }

        return treeNodeList;
    }

    private void generateTrees(List<TreeNode> treeNodeList, int n, int[] left, int[] right) {

        TreeNode node = new TreeNode(n);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            if(val <= 0){
                return "null";
            }
            return String.valueOf(val);
        }
    }

}
