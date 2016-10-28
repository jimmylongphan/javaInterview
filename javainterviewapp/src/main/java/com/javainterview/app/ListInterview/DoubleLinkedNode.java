package com.javainterview.app.ListInterview;

/**
 * Created on 9/27/2015.
 */
public class DoubleLinkedNode {
    public int key;
    public int value;
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;

    public DoubleLinkedNode() {
        pre = this;
        next = this;
    }

    /**
     * Constructor taking generics
     */
    public DoubleLinkedNode(int k, int v) {
        this.key = k;
        this.value = v;
        pre = this;
        next = this;
    }

}
