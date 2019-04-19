package com.syh.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-2
 * Time: 下午2:33
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree r = new ValidateBinarySearchTree();
        TreeNode tn1 = null;
        TreeNode tn2 = null;
        TreeNode tn3 = null;
        TreeNode tn4 = null;
        TreeNode tn5 = null;
        TreeNode tn6 = null;
        TreeNode tn7 = null;
        TreeNode tn8 = null;

        tn1 = new TreeNode(1);
        tn2 = new TreeNode(2);
        tn3 = new TreeNode(3);
        tn1.right = tn2; tn2.left = tn3;
        System.out.println(r.isValidBST(tn1));

        tn1 = new TreeNode(1);
        tn2 = new TreeNode(2);
        tn3 = new TreeNode(3);
        tn4 = new TreeNode(4);
        tn5 = new TreeNode(5);
        tn6 = new TreeNode(6);
        tn7 = new TreeNode(7);
        tn8 = new TreeNode(8);
        tn1.left = tn2; tn1.right = tn3;
        tn2.left = tn4; tn4.right = tn6;
        tn6.left = tn7; tn6.right = tn8;
        tn3.right = tn5;
        System.out.println(r.isValidBST(tn1));

        tn1 = new TreeNode(1);
        tn3 = new TreeNode(3);
        tn4 = new TreeNode(4);
        tn5 = new TreeNode(5);
        tn6 = new TreeNode(6);
        tn5.left = tn1; tn5.right = tn4;
        tn4.left = tn3; tn4.right = tn6;
        System.out.println(r.isValidBST(tn5));

        //        4
        //     ·   ·
        //    3       5
        //  ·         ·
        // 1             6
        tn1 = new TreeNode(1);
        tn3 = new TreeNode(3);
        tn4 = new TreeNode(4);
        tn5 = new TreeNode(5);
        tn6 = new TreeNode(6);
        tn4.left = tn3; tn3.left = tn1;
        tn4.right = tn5; tn5.right = tn6;
        System.out.println(r.isValidBST(tn4));

        //      10
        //    ·   ·
        //   5      15
        //        ·   ·
        //        6     20
        tn1 = new TreeNode(10);
        tn2 = new TreeNode(5);
        tn3 = new TreeNode(15);
        tn4 = new TreeNode(6);
        tn5 = new TreeNode(20);
        tn1.left = tn2; tn1.right = tn3;
        tn3.left = tn4; tn3.right = tn5;
        System.out.println(r.isValidBST(tn1));
        
        tn1 = new TreeNode(-2147483648);
        tn2 = new TreeNode(2147483647);
        tn1.right = tn2;
        System.out.println(r.isValidBST(tn1));
    }

    public boolean isValidBST(TreeNode root) {
        if(null == root){
            return true;
        }

        return help(root, Long.MIN_VALUE, Long.MAX_VALUE, false, false);
    }

    private boolean help(TreeNode node, long leftMax, long rightMix, boolean left, boolean right) {
        boolean result = true;
        if(node.left != null){
            result = result && node.val > node.left.val;
            if(!result) return result;
        }
        if(node.right != null){
            result = result && node.val < node.right.val;
            if(!result) return result;
        }
        if(left || right){
            result = result && node.val < rightMix;
            result = result && node.val > leftMax;
            if(!result) return result;
        }

        if(node.left != null) {
            result = result && help(node.left,
                    leftMax, Math.min(node.val, rightMix),
                    true, false);
        }
        if(node.right != null){
            result = result && help(node.right,
                    Math.max(node.val, leftMax), rightMix,
                    false, true);
        }

        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
