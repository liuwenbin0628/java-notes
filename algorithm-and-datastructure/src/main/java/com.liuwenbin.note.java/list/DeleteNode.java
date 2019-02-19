package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;

/**
 * @ Description：删除链表指定的节点
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class DeleteNode {

    /**
     * 删除节点a
     *
     * @param head 链表的头结点
     * @param a    待删除的节点
     * @return 头结点
     */
    public ListNode delete(ListNode head, ListNode a) {

        // 特殊情况
        if (head == null || a == null)
            return null;

        if (a.next != null) {
            // a不是尾结点
            ListNode next = a.next;
            a.val = next.val;
            a.next = next.next;
        } else {
            ListNode curr = head;
            while (curr.next != a) {
                curr = curr.next;
            }
            curr.next = null;
        }
        return head;
    }
}
