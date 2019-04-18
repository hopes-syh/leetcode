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
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal r = new BinaryTreeInorderTraversal();
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
        System.out.println(r.inorderTraversal(tn1));
        
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
        System.out.println(r.inorderTraversal(tn1));
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultArr = new ArrayList<>();
        if(root == null){
            return resultArr;
        }

        helper(root, resultArr);

        return resultArr;
    }

    private void helper(TreeNode node, List<Integer> resultArr) {
        if(node.left != null){
            helper(node.left, resultArr);
        }
        
        resultArr.add(node.val);
        
        if(node.right != null){
            helper(node.right, resultArr);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
