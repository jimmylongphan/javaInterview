package com.javainterview.app.ListInterview;

/**
 * TODO test
 * LeetCode 160
 *
 * Company: Amazon, Microsoft, Bloomberg, Airbnb
 *
 * Tags: Linked List
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *
 *
 *  A:          a1 ? a2
 *                      ?
 *                          c1 ? c2 ? c3
 *                      ?
 *  B:     b1 ? b2 ? b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Created on 10/5/2016.
 */
public class IntersectionList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if either node is null, return null
        if (headA == null | headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // loop while they are not intersecting
        while (a != null && b != null && a != b) {
            // not intersecting so we will increment
            a = a.next;
            b = b.next;

            // intersection point
            // this will definitely happen at the 2nd iteration when either of the
            // references get swapped
            // if there is no intersection point, they will both become null or
            // reach the end at the same time.
            if (a == b) {
                return a;
            }

            // when either of the references reaches the end before the other
            // we can continue our traversal by moving the reference to the other list
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
        }

        return a;
    }
}
