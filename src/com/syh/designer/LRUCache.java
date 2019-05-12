package com.syh.designer;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache;

        cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1) == 1 : " + (cache.get(1) == 1));
        cache.put(3, 3);
        System.out.println("cache.get(2) == -1 : " + (cache.get(2) == -1));
        cache.put(4, 4);
        System.out.println("cache.get(1) == -1 : " + (cache.get(1) == -1));
        System.out.println("cache.get(3) == 3 : " + (cache.get(3) == 3));
        System.out.println("cache.get(4) == 4 : " + (cache.get(4) == 4));

        cache = new LRUCache(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        System.out.println("cache.get(1) == -1 : " + (cache.get(1) == -1));
        cache.put(6, 6);
        System.out.println("cache.get(2) == -1 : " + (cache.get(2) == -1));
        System.out.println("cache.get(3) == 3 : " + (cache.get(3) == 3));
        cache.put(7, 7);
        System.out.println("cache.get(3) == 3 : " + (cache.get(3) == 3));
        System.out.println("cache.get(4) == -1 : " + (cache.get(4) == -1));
        System.out.println("cache.get(5) == 5 : " + (cache.get(5) == 5));
        cache.put(8, 8);
        cache.put(9, 9);
        cache.put(10, 10);
        cache.put(11, 11);
        System.out.println("cache.get(5) == 5 : " + (cache.get(5) == -1));

        cache = new LRUCache(1);
        cache.put(2, 2);                                             
        System.out.println("cache.get(2) == 2 : " + (cache.get(2) == 2));
        cache.put(3, 3);
        System.out.println("cache.get(2) == 2 : " + (cache.get(2) == -1));
        System.out.println("cache.get(3) == 3 : " + (cache.get(3) == 3));

        cache = new LRUCache(2);
        System.out.println("cache.get(2) == -1 : " + (cache.get(2) == -1));
        cache.put(2, 6);
        System.out.println("cache.get(1) == -1 : " + (cache.get(1) == -1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println("cache.get(1) == -1 : " + (cache.get(1) == 2));
        System.out.println("cache.get(2) == 6 : " + (cache.get(2) == 6));
    }

    public int capacity;
    public int size;
    public ListNode head, tail;
    public Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if(null == node){
            return -1;
        }
        if(head == node){
            return node.val;
        }

        ListNode pre = node.pre, next = node.next;
        if(tail == node){
            pre.next = next;
            tail = pre;
        } else {
            pre.next = next;
            next.pre = pre;
        }
        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;
        return head.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            get(key); // 通过get方法，将key对应的节点设为头节点；
            return;
        }

        if(null == head && null == tail){
            ListNode node = new ListNode(key, value);
            head = node;
            tail = node;
            ++size;
            map.put(key, node);
            return;
        }
        if(size < capacity){
            ListNode node = new ListNode(key, value);
            ListNode next = head;
            node.next = next;
            next.pre = node;
            head = node;
            ++size;
            map.put(key, node);
            return;
        }

        ListNode node = tail;
        tail = tail.pre;
        node.pre = null;
        if(tail == null)
            head = null;
        else {
            tail.next = null;
        }
        --size;
        map.remove(node.key);
        put(key, value);
    }

    static class ListNode {
        int key, val;
        ListNode next;
        ListNode pre;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            ListNode curr = this;
            while (curr != null){
                result.append(curr.key).append("->");
                curr = curr.next;
            }
            return result.toString();
        }
    }
}
