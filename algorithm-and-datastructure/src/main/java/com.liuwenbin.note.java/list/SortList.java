package com.liuwenbin.note.java.list;

import com.liuwenbin.note.java.api.ListNode;

/**
 * @ Description：排序单链表（归并排序的变形）
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/8
 */

public class SortList {

    public ListNode sort(ListNode head) {

        // 1 处理边界
        if (head == null || head.next == null) return head;

        // 2 切分
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 3 分别排序并合并（核心代码）
        return merge(sort(head), sort(slow));

    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode a, ListNode b) {

        // 1 定义两个辅助节点，head为虚拟头结点，curr为遍历链表的临时节点
        ListNode head = new ListNode(0), curr = head;

        // 2 排序
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        // 3 处理剩下的
        curr.next = a == null ? b : a;
        return head.next;
    }
}
