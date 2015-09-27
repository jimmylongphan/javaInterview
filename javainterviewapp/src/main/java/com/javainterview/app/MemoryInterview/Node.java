package com.javainterview.app.MemoryInterview;

/**
 * Created on 9/27/2015.
 */
public class Node<K, V> {
    K k;
    V v;
    Node pre, next;

    /**
     * Constructor taking generics
     */
    public Node(K k, V v) {
        this.k = k;
        this.v = v;
        pre = this;
        next = this;
    }

    public K getKey() {
        return this.k;
    }

    public V getValue() {
        return this.v;
    }

    public void setValue(V v) {
        this.v = v;
    }

    public Node getPre() {
        return this.pre;
    }

    public Node getNext() {
        return this.next;
    }
}
