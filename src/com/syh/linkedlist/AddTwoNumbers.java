package com.syh.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-11
 * Time: 下午10:57
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers st = new AddTwoNumbers();
        ListNode l11 = null;
        ListNode l12 = null;
        ListNode l13 = null;
        ListNode l21 = null;
        ListNode l22 = null;
        ListNode l23 = null;

        l11 = new ListNode(2);
        l12 = new ListNode(4);
        l13 = new ListNode(3);
        l21 = new ListNode(5);
        l22 = new ListNode(6);
        l23 = new ListNode(4);
        l11.next=l12; l12.next=l13;
        l21.next=l22; l22.next=l23;
        System.out.println(st.addTwoNumbers(l11, l21));

        l11 = new ListNode(2);
        l12 = new ListNode(4);
        l21 = new ListNode(5);
        l22 = new ListNode(6);
        l23 = new ListNode(4);
        l11.next=l12;
        l21.next=l22; l22.next=l23;
        System.out.println(st.addTwoNumbers(l11, l21));

        l11 = new ListNode(2);
        l12 = new ListNode(4);
        l13 = new ListNode(3);
        l21 = new ListNode(5);
        l22 = new ListNode(6);
        l11.next=l12; l12.next=l13;
        l21.next=l22;
        System.out.println(st.addTwoNumbers(l11, l21));

        l11 = new ListNode(5);
        l21 = new ListNode(5);
        System.out.println(st.addTwoNumbers(l11, l21));

        l11 = new ListNode(1);
        l21 = new ListNode(9);
        l22 = new ListNode(9);     l21.next=l22;
        System.out.println(st.addTwoNumbers(l11, l21));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null, l31 = null;

        int gewei = 0, shiwei = 0;
        while (l1!=null || l2!=null || shiwei!=0){
            if(l1==null && l2!=null){
                int l3v = l2.val+shiwei;
                gewei = l3v%10;

                if(l3==null){
                    l3 = new ListNode(gewei);
                    l31 = l3;
                }
                else{
                    l3.next = new ListNode(gewei);
                    l3 = l3.next;
                }

                l2 = l2.next;
                shiwei = 0;
                if(l3v>=10){
                    shiwei = l3v%100/10;
                }
            }
            else if(l1!=null && l2==null){
                int l3v = l1.val+shiwei;
                gewei = l3v%10;

                if(l3==null){
                    l3 = new ListNode(gewei);
                    l31 = l3;
                }
                else {
                    l3.next = new ListNode(gewei);
                    l3 = l3.next;
                }

                l1 = l1.next;
                shiwei = 0;
                if(l3v>=10){
                    shiwei = l3v%100/10;
                }
            }
            else if(l1!=null && l2!=null){
                int l3v = l1.val+l2.val+shiwei;
                gewei = l3v%10;

                if(l3==null){
                    l3 = new ListNode(gewei);
                    l31 = l3;
                }
                else{
                    l3.next = new ListNode(gewei);
                    l3 = l3.next;
                }

                l1 = l1.next; l2 = l2.next;
                shiwei = 0;
                if(l3v>=10){
                    shiwei = l3v%100/10;
                }
            }
            else{
                if(l3==null){
                    l3 = new ListNode(shiwei);
                    l31 = l3;
                }
                else{
                    l3.next = new ListNode(shiwei);
                    l3 = l3.next;
                }
                shiwei = 0;
            }
        }

        return l31;
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

