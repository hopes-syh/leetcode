package com.syh.twopointers;

/**
 * https://leetcode-cn.com/classic/problems/partition-list/description/
 */
public class PartitionList {

    public static void main(String[] args) {
        PartitionList p = new PartitionList();

        ListNode node1 = null, node2 = null, node3 = null, node4 = null, node5 = null, node6 = null;
        node1 = new ListNode(1);
        node2 = new ListNode(4);
        node3 = new ListNode(3);
        node4 = new ListNode(2);
        node5 = new ListNode(5);
        node6 = new ListNode(2);
        node1.next = node2; node2.next = node3; node3.next = node4;
        node4.next = node5; node5.next = node6;
        System.out.println(p.partition(node1, 3));

        node1 = new ListNode(4);
        node2 = new ListNode(1);
        node3 = new ListNode(3);
        node4 = new ListNode(2);
        node5 = new ListNode(5);
        node6 = new ListNode(2);
        node1.next = node2; node2.next = node3; node3.next = node4;
        node4.next = node5; node5.next = node6;
        System.out.println(p.partition(node1, 3));
    }
    
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode node = head, preNode = preHead, sgnode = null, preSgNode = null;
        while (node != null){
            if(node.val >= x && sgnode == null){
                sgnode = node;
                preSgNode = preNode;
            }
            else if(node.val < x && sgnode != null){
                preNode.next = node.next;
                preSgNode.next = node;
                node.next = sgnode;

                preSgNode = node;
                node = preNode.next;
                continue;
            }

            preNode = node;
            node = node.next;
        }

        return preHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode n = this;
            while (n!=null){
                sb.append(n.val).append("->");
                n = n.next;
            }
            return sb.toString();
        }
    }
}
