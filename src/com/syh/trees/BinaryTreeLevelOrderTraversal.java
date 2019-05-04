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
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal r = new BinaryTreeLevelOrderTraversal();
        TreeNode n1, n2, n3, n4, n5, n6, n7;
        List<List<Integer>> list = null;

        n1 = new TreeNode(3);
        n2 = new TreeNode(9);
        n3 = new TreeNode(20);
        n4 = new TreeNode(15);
        n5 = new TreeNode(7);
        n1.left = n2; n1.right = n3;
        n3.left = n4; n3.right = n5;
        list = r.levelOrder(n1);
        System.out.println(list);

        n1 = new TreeNode(3);
        n2 = new TreeNode(9);
        n6 = new TreeNode(10);
        n3 = new TreeNode(20);
        n4 = new TreeNode(15);
        n5 = new TreeNode(7);
        n1.left = n2; n1.right = n3;
        n2.right = n6;
        n3.left = n4; n3.right = n5;
        list = r.levelOrder(n1);
        System.out.println(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<TreeNode> nodes = new ArrayList<TreeNode>(); nodes.add(root);
        help(result, null, nodes);
        return result;
    }

    public void help(List<List<Integer>> result, List<Integer> list, List<TreeNode> nodes){
        if(null == nodes || nodes.size() <= 0){
            return;
        }

        List<TreeNode> nNodes = new ArrayList<>();
        list = new ArrayList<>();
        for(TreeNode node : nodes){
            list.add(node.val);
            if (node.left != null){
                nNodes.add(node.left);
            }
            if (node.right != null){
                nNodes.add(node.right);
            }
        }
        result.add(list);
        help(result, null, nNodes);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
