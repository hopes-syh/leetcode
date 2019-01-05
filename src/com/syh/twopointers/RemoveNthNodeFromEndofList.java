package com.syh.twopointers;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 **/
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();

        ListNode n1 =  null;
        ListNode n2 = null;
        ListNode n3 = null;
        ListNode n4 = null;
        ListNode n5 = null;

        //n1 = new ListNode(1);
        //n2 = new ListNode(2);
        //n3 = new ListNode(3);
        //n4 = new ListNode(4);
        //n5 = new ListNode(5);
        //n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        //System.out.println(r.removeNthFromEnd(n1, 2));

        //n1 = new ListNode(1);
        //n2 = new ListNode(2);
        //n3 = new ListNode(3);
        //n4 = new ListNode(4);
        //n5 = new ListNode(5);
        //n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        //System.out.println(r.removeNthFromEnd(n1, 1));

        //n1 = new ListNode(1);
        //n2 = new ListNode(2);
        //n3 = new ListNode(3);
        //n4 = new ListNode(4);
        //n5 = new ListNode(5);
        //n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        //System.out.println(r.removeNthFromEnd(n1, 5));

        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);
        n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        System.out.println(r.removeNthFromEnd(n1, 4));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0 || null==head){
            return head;
        }

        ListNode newHead = head;
        ListNode n0 = head, n1 = head, n2 = head;
        int n2Index = 1, n2Ton1 = 0;
        while (n2.next != null){
            n2 = n2.next;
            ++n2Index;

            if(n2Ton1 < n)
                ++n2Ton1;

            if(n2Ton1 == n){
                n0 = n1;
                n1 = n1.next;
            }
        }

        if(newHead.equals(n1)){
            newHead = n1.next;
            n1.next = null;
        }
        else {
            n0.next = n1.next;
            n1.next = null;
        }

        return newHead;
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
