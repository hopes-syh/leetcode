package com.syh.trees;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal t = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = t.buildTree(preorder, inorder);
        System.out.println(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = help(null, preorder, inorder);
        return node;
    }

    public TreeNode help(TreeNode node, int[] preorder, int[] inorder){
        int preLen = preorder.length;
        int inLen = inorder.length;
        if(preLen <= 0 || inLen <= 0){
            return node;
        }

        int val = preorder[0];
        node = new TreeNode(val);
        if(preLen<=1 || inLen<=1)
            return node;

        for(int i=0; i<inLen; i++){
            if(inorder[i] != val){
                continue;
            }

            int[] lpre = Arrays.copyOfRange(preorder, 1, i+1);
            int[] lin = Arrays.copyOfRange(inorder, 0, i);
            node.left = help(null, lpre, lin);

            if(i+1 < preLen) {
                int[] rpre = Arrays.copyOfRange(preorder, i+1, preLen);
                int[] rin = Arrays.copyOfRange(inorder, i+1, inLen);
                node.right = help(null, rpre, rin);
            }
            break;
        }

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
