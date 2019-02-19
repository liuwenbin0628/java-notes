package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;

/**
 * @ Description：删除链表中重复的结点
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class DeleteDuplication {

    public ListNode delete(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;

        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return delete(next);
        } else {
            head.next = delete(next);
            return head;
        }


    }
}
