package com.javainterview.app.ListInterview;

/**
 * Created on 9/30/2015.
 *
 * Ensure that the generic contains a compareTo method.
 * This is so we can compare the values.
 * And use it to compare the ListNode itself.
 */
public class ListNode<T extends Comparable<T>> {
    public T value;
    ListNode<T> pre;
    ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    /**
     * High level compareTo
     *
     * @param node that implements compareTo
     * @return -1 if this is less, 0 if equal, 1 if o is greater
     */
    public int compareTo(ListNode<T> node) {
        return value.compareTo(node.value);
    }
}
