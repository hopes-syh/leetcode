package com.syh.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-30
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
 */
public class SwapNodesinPairs {

    public static void main(String[] args) {
        SwapNodesinPairs st = new SwapNodesinPairs();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        // ListNode n3 = new ListNode(3);
        // ListNode n4 = new ListNode(4);
        // ListNode n5 = new ListNode(5);
        n1.next = n2; // n2.next = n3; // n3.next = n4; n4.next = n5;

        System.out.println(st.swapPairs(n1));
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        int index = 0;
        ListNode curr = head, newhead = null, prepre = null, pre = null, next = null;
        while (curr != null){
            ++index;
            if(index % 2 == 1){
                pre = curr;
                curr = curr.next;
                continue;
            }

            next = curr.next;

            pre.next = next;
            curr.next = pre;
            if(index == 2){
                newhead = curr;
            }
            if(prepre != null){
                prepre.next = curr;
            }
            if(next != null){
                prepre = pre;
                curr = next;
            }
            else{
                break;
            }
        }

        return newhead;
    }

}

class ListNode {
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
