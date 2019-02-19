package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;

/**
 * @ Description：已知两个链表存在交点，找到他们的第一个交点
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 */

public class FirstCommonNode {

    public ListNode findFirstCommonNode(ListNode aHead, ListNode bHead) {
        ListNode a = aHead, b = bHead;

        while (a != b) {
            a = (a == null)
                    ? bHead
                    : a.next;
            b = (b == null)
                    ? aHead
                    : b.next;
        }
        return a;
    }
}
