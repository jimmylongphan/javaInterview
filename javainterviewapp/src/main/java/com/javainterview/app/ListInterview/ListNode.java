package com.javainterview.app.ListInterview;

/**
 * Created on 9/30/2015.
 *
 * Ensure that the generic contains a compareTo method.
 * This is so we can compare the values.
 * And use it to compare the ListNode itself.
 */
public class ListNode {
    public Integer val;
    ListNode pre;
    ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode( ListNode node ) {
        this.val = node.val;
        this.pre = node.pre;
        this.next = node.next;
    }

    /**
     * High level compareTo
     *
     * @param node that implements compareTo
     * @return -1 if this is less, 0 if equal, 1 if o is greater
     */
    public int compareTo(ListNode node) {
        return val.compareTo(node.val);
    }
}
