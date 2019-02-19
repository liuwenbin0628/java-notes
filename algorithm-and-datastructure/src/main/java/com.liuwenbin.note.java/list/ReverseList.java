package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;
import org.w3c.dom.ls.LSException;

/**
 * @ Description：翻转链表
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */
 
public class ReverseList {

    public static ListNode reverseList(ListNode head) {

        if (head == null) return null;

        ListNode pre = null, next = null;

        while (head != null) {
             next = head.next;
             head.next = pre;
             pre = head;
             head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(head.val+" "+ head.next.val+" "+ head.next.next.val);
        ListNode newHead = reverseList(head);
        System.out.println(newHead.val+" "+ newHead.next.val+" "+ newHead.next.next.val);
    }
}
