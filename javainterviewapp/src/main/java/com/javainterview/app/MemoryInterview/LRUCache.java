package com.javainterview.app.MemoryInterview;

import com.javainterview.app.ListInterview.DoubleLinkedNode;

import java.util.HashMap;

/**
 * LeetCode: 146
 *
 * Company: All
 * Tags: Design
 *
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
 * The head is a place holder for the linked list.
 * The tail is a place holder for the end of the list.
 */
public class LRUCache {
    private HashMap<Integer, DoubleLinkedNode> cache;
    private int count;
    private int capacity;
    private DoubleLinkedNode head = null;
    private DoubleLinkedNode tail = null;

    /**
     * Add the new node after the head
     * @param node the new node at beginning
     */
    private void addNode(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /**
     * Remove this node from the data structure
     *
     * @param node node to remove
     */
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    /**
     * Move this node to the head of the list
     * @param node node to move
     */
    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * Remove the tail from the list
     * @return the removed tail node
     */
    private DoubleLinkedNode popTail() {
        DoubleLinkedNode result = tail.pre;
        this.removeNode(result);
        return result;
    }

    /**
     * Initialize the cache
     * @param capacity size of the cache
     */
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;

        // create the absolute head node
        head = new DoubleLinkedNode();
        head.pre = null;

        tail = new DoubleLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    /**
     * retrieve the val given a key in this cache
     * @param key key to find
     * @return val of cache
     */
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // using least recently used, move this to head
        this.moveToHead(node);

        // return the val
        return node.value;
    }

    /**
     * If there is no node, then create and add to list and cache.
     * Remove the tail if we reached capacity.
     * If there is a node, then update its val, move to head because least recently used
     * @param key key of cache
     * @param value val to retrieve
     */
    public void set(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;

            if (count > capacity) {
                // pop the tail node
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the val in the node
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Check if the lru is full
     * @return true if full
     */
    public boolean isFull() {
        return this.count == this.capacity;
    }
}
