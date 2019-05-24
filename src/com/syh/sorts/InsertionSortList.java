package com.syh.sorts;

/**
 * https://leetcode.com/problems/insertion-sort-list/submissions/
 */
public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList st = new InsertionSortList();
        ListNode l1 = null, l2 = null, l3 = null, l4 = null, l5 = null, l6 = null, l7 = null, l8 = null;

        /*l1 = new ListNode(1);
        l2 = new ListNode(2);
        l3 = new ListNode(3);
        l4 = new ListNode(4);
        l4.next = l2; l2.next = l1; l1.next = l3;
        System.out.println(st.insertionSortList(l4));

        l1 = new ListNode(1);
        l2 = new ListNode(2);
        l3 = new ListNode(3);
        l4 = new ListNode(4);
        l5 = new ListNode(5);
        l6 = new ListNode(6);
        l7 = new ListNode(7);
        l8 = new ListNode(8);
        l8.next = l7; l7.next = l6; l6.next = l5; l5.next = l4;
        l4.next = l3; l3.next = l2; l2.next = l1;
        System.out.println(st.insertionSortList(l8));*/

        l1 = new ListNode(6);
        l2 = new ListNode(5);
        l3 = new ListNode(3);
        l4 = new ListNode(1);
        l5 = new ListNode(8);
        l6 = new ListNode(7);
        l7 = new ListNode(2);
        l8 = new ListNode(4);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
        l5.next = l6; l6.next = l7; l7.next = l8;
        System.out.println(st.insertionSortList(l1));
    }

    public ListNode insertionSortList(ListNode head) {
        if(null == head){
            return head;
        }

        ListNode move = null, preLoop = null, loop = null, node = head;
        while (null != node.next){
            move = node.next;

            loop = head;
            while (null != loop){
                if(loop.val > move.val){
                    if(loop.equals(head)){
                        node.next = move.next;
                        move.next = loop;
                        head = move;
                    }
                    else {
                        node.next = move.next;
                        move.next = loop;
                        preLoop.next = move;
                    }
                    break;
                }
                else if(loop.equals(move)){
                    node = move;
                    break;
                }
                preLoop = loop;
                loop = loop.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            ListNode curr = this;
            while (curr != null){
                result.append(curr.val).append("->");
                curr = curr.next;
            }
            return result.toString();
        }
    }
}
