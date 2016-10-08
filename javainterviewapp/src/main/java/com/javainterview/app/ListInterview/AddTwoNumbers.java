package com.javainterview.app.ListInterview;

/**
 * LeetCode 2
 *
 * Company: Amazon, Microsoft, Bloomberg, Airbnb, Adobe
 *
 * Tags: Linked List, Math
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Created on 10/8/2016.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int sum = 0;

        while (l1 != null || l2 != null) {
            // the sum is used to store the carry
            sum /= 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // store the ones digit into the next node
            current.next = new ListNode(sum % 10);
            // move the current node
            current = current.next;
        }

        // if there is an extra carry
        if (sum / 10 == 1) {
            current.next = new ListNode(1);
        }

        // return the beginning of the list
        return dummyHead.next;
    }

}
