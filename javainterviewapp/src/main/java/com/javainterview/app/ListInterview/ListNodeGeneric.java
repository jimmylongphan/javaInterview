package com.javainterview.app.ListInterview;

/**
 * Created on 9/21/2015.
 *
 * Ensure that the generic contains a compareTo method.
 * This is so we can compare the values.
 * And use it to compare the ListNode itself.
 */
public class ListNodeGeneric<T extends Comparable<T>> {
    public T val;
    ListNodeGeneric<T> pre;
    ListNodeGeneric<T> next;

    public ListNodeGeneric(T value) {
        this.val = value;
    }

    public ListNodeGeneric(ListNodeGeneric<T> node) {
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
    public int compareTo(ListNodeGeneric<T> node) {
        return val.compareTo(node.val);
    }
}
