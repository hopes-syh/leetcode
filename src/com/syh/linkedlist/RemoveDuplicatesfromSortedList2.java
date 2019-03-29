package com.syh.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-3-30
 * Time: 上午1:23
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesfromSortedList2 {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList2 st = new RemoveDuplicatesfromSortedList2();
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode l3 = null;
        ListNode l4 = null;
        ListNode l5 = null;
        ListNode l6 = null;
        ListNode l7 = null;

        l1 = new ListNode(1);
        l2 = new ListNode(2);
        l3 = new ListNode(3);
        l4 = new ListNode(3);
        l5 = new ListNode(4);
        l6 = new ListNode(4);
        l7 = new ListNode(5);
        l1.next=l2; l2.next=l3; l3.next=l4;
        l4.next=l5; l5.next=l6; l6.next=l7;
        System.out.println(st.deleteDuplicates(l1));

        l1 = new ListNode(1);
        l2 = new ListNode(1);
        l3 = new ListNode(2);
        l4 = new ListNode(3);
        l5 = new ListNode(4);
        l6 = new ListNode(4);
        l7 = new ListNode(5);
        l1.next=l2; l2.next=l3; l3.next=l4;
        l4.next=l5; l5.next=l6; l6.next=l7;
        System.out.println(st.deleteDuplicates(l1));

        l1 = new ListNode(1);
        l2 = new ListNode(1);
        l3 = new ListNode(1);
        l4 = new ListNode(2);
        l5 = new ListNode(4);
        l6 = new ListNode(4);
        l7 = new ListNode(5);
        l1.next=l2; l2.next=l3; l3.next=l4;
        l4.next=l5; l5.next=l6; l6.next=l7;
        System.out.println(st.deleteDuplicates(l1));

        l1 = new ListNode(1);
        l2 = new ListNode(2);
        l3 = new ListNode(2);
        l4 = new ListNode(2);
        l5 = new ListNode(3);
        l1.next=l2; l2.next=l3; l3.next=l4;
        l4.next=l5;
        System.out.println(st.deleteDuplicates(l1));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        int repeatVal = Integer.MIN_VALUE+1;
        ListNode cur = head, pre = head;
        boolean repeatHead = true;
        while (cur != null){
            int curV = cur.val;
            ListNode cur1N = cur.next != null ? cur.next : null;
            int cur1V = cur1N != null ? cur1N.val : Integer.MAX_VALUE;
            ListNode cur2N = cur1N != null && cur1N.next != null ? cur1N.next : null;

            if(curV == cur1V && repeatHead){
                pre = cur2N;
                cur = cur2N;
                head = cur;
                repeatVal = curV;
                continue;
            }
            if(repeatVal == curV && repeatHead){
                pre = cur1N;
                cur = cur1N;
                head = cur;
                continue;
            }
            if((curV == cur1V || repeatVal == curV) && !repeatHead){
                pre.next = cur1N;
                cur = cur1N;
                repeatVal = curV;
                continue;
            }

            pre = cur;
            cur = cur.next;
            repeatHead = false;
        }

        return head;
    }

    public static class ListNode {
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
