package com.javainterview.app.ListInterview;

/**
 * Created on 11/20/2016.
 *
 * LeetCode 61: Rotate list
 *
 * Given a list, rotate the list to the right by k places, where k i nonnegative
 *
 * 1->2->3->4->5->NULL and k = 2, new tail is at 2, new head is at 3
 * 4->5->1->2->3->NULL
 *
 *
 *
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // starting at the head node
        int length = 1;
        ListNode currentTail = head;

        // get the current tail and the length of the list
        while (currentTail.next != null) {
            length++;
            currentTail = currentTail.next;
        }

        // 5 - (2 % 5) = 5 - 3 = 2
        int breakIndex = length - k % length;

        ListNode newTail = head;
        // already starting at head, moving to new tail
        for (int i=0; i < breakIndex - 1; i++) {
            newTail = newTail.next;
        }

        // rotate the list
        currentTail.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
