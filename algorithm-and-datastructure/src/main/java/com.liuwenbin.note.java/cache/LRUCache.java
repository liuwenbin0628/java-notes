package com.liuwenbin.note.java.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description：LRU缓存，要求put和get操作的时间复杂度都是O(1)
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */

public class LRUCache {

    private class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private int capacity;                             // 容量
    private Map<Integer, Node> map = new HashMap<>(); // 缓存

    /* 链表头尾节点，注意：这两个节点是辅助节点 */
    private Node head = new Node(-1, -1);   // 头节点
    private Node tail = new Node(-1, -1);   // 尾节点

    /**
     * 初始化LRU缓存，做两件事，1 初始化容量， 2 初始化双向链表
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 对外暴露的get方法，时间复杂度O(1)
     */
    public int get(int key) {
        // 1 查看是否存在，不存在返回-1
        if (!map.containsKey(key)) return -1;
        // 2 存在，获取节点
        Node curr = map.get(key);
        // 3 将节点移动到链表尾部，表示最近使用的 <br/>
        // 3.1 从双向链表中先删除自己
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
        // 3.2 尾部新建该节点
        moveToTail(curr);
        // 4 返回
        return curr.val;
    }

    /**
     * 对外暴露的put方法
     */
    public void put(int key, int val) {
        // 1 已经存在key -> 直接覆盖旧值，get()方法会将节点移到队尾
        if (get(key) != -1) {
            map.get(key).val = val;
        }
        // 2 不存在 ->
        else {
            // 3 是否到容量阈值了，是 -> 淘汰最不常用的节点(表头的下一个结点)
            if (map.size() == capacity) {
                // 3.1 缓存先淘汰
                map.remove(head.next.key);
                // 3.2 淘汰链表表头的下一个结点
                head.next = head.next.next;
                head.next.pre = head;
            }
            // 4 新建一个结点，放在缓存和表尾
            Node insert = new Node(key, val);
            map.put(key, insert);
            moveToTail(insert);
        }
    }

    private void moveToTail(Node curr) {
        curr.next = tail;
        tail.pre.next = curr;
        curr.pre = tail.pre;
        tail.pre = curr;
    }
}
