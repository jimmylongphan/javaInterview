package com.javainterview.app.MemoryInterview;

import java.util.HashMap;


/**
 * Created on 9/27/2015.
 *
 * There are 2 parts to this cache.
 * Map is used to quickly access any nodes given a key.
 * However, we still need to determine the least recently used key.
 * LRU will be determined by a linked list.
 *
 * Everytime a key is accessed, it is moved to the front of the list.
 * If we need to remove a node, then we remove it from the end.
 *
 * The header is a place holder for the linked list.
 */
public class LRUCache<K, V> {
    // keys are the values and nodes is a linked list
    HashMap<K, Node> map = new HashMap<K, Node>();

    int capacity;
    int size;

    Node header;

    public LRUCache(int capacity) {
        // set the settings for the cache
        this.capacity = capacity;

        // current size
        this.size = 0;

        // create a dummy header
        header = new Node(-1, -1);
    }

    /**
     * Adding a new entry into the cache
     */
    private void add(K k, V v) {
        // check if already hit this value
        if (map.containsKey(k)) {
            // retrieve current nodes
            Node node = map.get(k);

            // update node value
            node.setValue(v);

            // retrieve the node from the linked list
            isolate(node);

            // add this value front of the list
            addFirst(node);
        } else {
            // create new node since it has not been seen before
            Node node = new Node(k, v);
            // put node into the map
            map.put(k, node);

            // if this cache is full, remove and add nodes
            if (isFull()) {
                // remove the last node
                // size is already at max
                removeLast();
            } else {
                // just add the node and update size
                size++;
            }
            // add the node into the linked list
            addFirst(node);
        }
    }

    /**
     * Retrieve the node from the cache given a key
     */
    private Node get(K k) {
        // cache contains this key
        if (map.containsKey(k)) {
            Node node = map.get(k);

            // move the node to the front of the list
            isolate(node);
            addFirst(node);
            return node;
        } else {
            // element not in the cache
            return null;
        }
    }

    /**
     * Remove the last node.
     * Occurs when the cache is full.
     */
    private void removeLast() {
        // retrieve neighboring nodes
        Node last = header.pre;
        Node pre = last.pre;

        // detach last node
        header.pre = pre;
        pre.next = header;

        // reset links
        last.pre = last;
        last.next = last;

        // remove node from map
        map.remove(last.getKey());
    }

    /**
     * Check if the cache has reached capacity
     */
    private boolean isFull() {
        return size == capacity;
    }

    /**
     * Insert the node at the head
     * The very first node is a dummy node
     */
    private void addFirst(Node node) {
        Node next = header.next;
        // new node is the first after the dummy
        header.next = node;
        next.pre = node;

        // set the new nodes links
        node.pre = header;
        node.next = next;
    }


    /**
     * Detach this node from the link
     */
    private void isolate(Node node) {
        // retrieve neighbor nodes
        Node pre = node.pre;
        Node next = node.next;

        // detach node
        pre.next = next;
        next.pre = pre;

        // reset links
        node.next = node;
        node.pre = node;
    }

}
