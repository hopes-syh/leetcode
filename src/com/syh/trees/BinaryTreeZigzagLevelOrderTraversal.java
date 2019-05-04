package com.syh.trees;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-2
 * Time: 下午2:33
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal r = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode n1, n2, n3, n4, n5, n6, n7;
        List<List<Integer>> list = null;

        n1 = new TreeNode(3);
        n2 = new TreeNode(9);
        n3 = new TreeNode(20);
        n4 = new TreeNode(15);
        n5 = new TreeNode(7);
        n1.left = n2; n1.right = n3;
        n3.left = n4; n3.right = n5;
        list = r.zigzagLevelOrder(n1);
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
        list = r.zigzagLevelOrder(n1);
        System.out.println(list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> nodes = new Stack<>(); nodes.push(root);
        help(result, null, nodes, 0);
        return result;
    }

    public void help(List<List<Integer>> result, List<Integer> list, Stack<TreeNode> nodes, int idx){
        int toLeft = idx % 2, size = nodes.size();
        if(null == nodes || size <= 0){
            return;
        }

        Stack<TreeNode> nNodes = new Stack<>();
        TreeNode node; list = new ArrayList<>();
        while (!nodes.empty()){
            node = nodes.pop();
            list.add(node.val);

            if(toLeft == 0) {
                if (node.left != null) nNodes.push(node.left);
                if (node.right != null) nNodes.push(node.right);
            } else {
                if(node.right != null) nNodes.add(node.right);
                if(node.left != null) nNodes.add(node.left);
            }
        }
        result.add(list);
        help(result, null, nNodes, ++idx);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
