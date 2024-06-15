package com.leetcode.linkedList;

import com.models.ListNode;

/*
IDEA:
    * Find the middle of Node in LinkedList
    * Reverse From middle.next to end of LinkedList
    * then calc pair sum and compare with max value
 */
public class MaximumTwinSum {
    public static int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode start = head;
        ListNode middle = middleNode(head);
        middle.next = reverseLinkedList(middle.next);
        middle = middle.next;
        while (middle != null) {
            max = Math.max((start.val + middle.val), max);
            start = start.next;
            middle = middle.next;
        }
        return max;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1, null))));
        int maxPairsum = pairSum(head);
        System.out.println(maxPairsum);

    }
}
