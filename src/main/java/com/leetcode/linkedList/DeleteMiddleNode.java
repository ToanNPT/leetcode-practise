package com.leetcode.linkedList;

import com.models.ListNode;

public class DeleteMiddleNode {
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode a = deleteMiddle(head);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
