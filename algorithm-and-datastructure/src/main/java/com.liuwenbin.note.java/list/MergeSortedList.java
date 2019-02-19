package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;

/**
 * @ Description：合并两个已排序的链表
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class MergeSortedList {

    // 方法一：递归
    public ListNode merge1(ListNode listA, ListNode listB) {
        if (listA == null) return listB;
        if (listB == null) return listA;

        if (listA.val < listB.val) {
            listA.next = merge1(listA.next, listB);
            return listA;
        } else {
            listB.next = merge1(listA, listB.next);
            return listB;
        }
    }

    // 方法二：迭代
    public ListNode merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return head.next;
    }
}
