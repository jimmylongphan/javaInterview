package com.javainterview.app.ListInterview;

import java.util.PriorityQueue;

/**
 * LeetCode: 23
 * 
 * Company:
 * LinkedIn, Google, Uber, Airbnb, Facebook, Twitter, Amazon, Microsoft
 *
 * Tags: Divide and Conquer, Linked List, Heap
 * 
 * Problem:
 * Merge k sorted Linked lists and return as one sorted list
 *
 * Time complexity:
 * O(n log k)
 * n is number of lists
 * k is total number of nodes
 * 
 * PriorityQueue uses a tree where insertion is log k
 */
public class MergeKLists {

    /**
     * @param lists Array of listNodes.  Each list is already sorted
     * @return One ListNode with all values
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // boundary check
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // use a priority queue
        // this case is sorted from least to greatest
        // use java 8 lambda for the comparator
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
            (ListNode x, ListNode y) -> x.val - y.val);
        
        // create a dummy to be the head
        ListNode dummyHead = new ListNode(0);
        
        // initialize the tail to be the dummy
        ListNode tail = dummyHead;
        
        // go through all lists (size n)
        // total size of queue shall be k, insertion is log k
        // because it uses a binary tree
        for (ListNode listHead : lists) {
            if (listHead != null) {
                // insert each list head
                queue.add(listHead);
            }
        }
        
        // at this point all the heads from the list array are in the queue
        while (!queue.isEmpty()) {
            // remove the head of the queue
            // add it to our tail
            tail.next = queue.poll();
            
            // update the tail
            tail = tail.next;
            
            // check for children or next elements in the newly added node
            if (tail.next != null) {
                // add them to the queue
                queue.add(tail.next);
            }
        }
        
        // dummy points to actual head
        return dummyHead.next;
    }
    
}