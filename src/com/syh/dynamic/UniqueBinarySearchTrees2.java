package com.syh.dynamic;

import sun.reflect.generics.tree.Tree;

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
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTrees2 {


    public static void main(String[] args) {
        UniqueBinarySearchTrees2 st = new UniqueBinarySearchTrees2();

        System.out.println(st.generateTrees(1));
        System.out.println(st.generateTrees(2));
        System.out.println(st.generateTrees(3));
        System.out.println(st.generateTrees(4));
        System.out.println(st.generateTrees(5));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeList = new ArrayList<>();
        if(n <= 0){
            return treeList;
        }
        treeList.add(null);

        for(int i=1; i<=n; i++){
            List<TreeNode> cur = new ArrayList<TreeNode>();

            for(TreeNode root : treeList) {
                // 添加到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);

                for(int j=0; j<=n; j++){
                    TreeNode rootCopy = copyTree(root); //复制当前的树
                    TreeNode right = rootCopy; //找到要插入右孩子的位置

                    for(int k=0; k<j; k++){
                        if(right == null){
                            break;
                        }
                        right = right.right;
                    }

                    if(right == null){
                        break;
                    }
                    TreeNode rightNode = right.right;
                    insert = new TreeNode(i);
                    right.right = insert;
                    insert.left = rightNode;
                    cur.add(rootCopy);
                }
            }

            treeList = cur;
        }

        return treeList;
    }

    public TreeNode copyTree(TreeNode node){
        if(null == node){
            return null;
        }
        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = copyTree(node.left);
        treeNode.right = copyTree(node.right);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            value(sb, this);
            return sb.toString();
        }

        private void value(StringBuilder sb, TreeNode treeNode){
            sb.append(null == treeNode ? "null" : treeNode.val);
            sb.append("-");
            if(null == treeNode){
                return;
            }

            value(sb, treeNode.left);
            value(sb, treeNode.right);
        }
    }

}
