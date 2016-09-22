package com.javainterview.app.ListInterview;

/**
 * LeetCode: 141
 * Company: Amazon, Microsoft, Bloomberg, Yahoo
 * Tags: Linked List, Two Pointers
 * 
 * Created on 2/28/2016.
 *
 * Given a list, determine if there is a cycle in the list.
 * 
 * Space: O(1)
 * Time: O(n)
 */
public class DetectCycle {

    /**
     * We will use two references in the list.
     * The first references moves one node at a time.
     * The second reference moves two nodes.
     *
     * When both references are the same node, then there is a cycle.
     * If we reached the end, then there is no cycle.
     *
     * @param node beginning of list
     * @return boolean
     */
    public boolean hasCycle( ListNode node ) {
        // boundary checking
        if (node == null) {
            return false;
        }

        ListNode firstNode = node;
        ListNode secondNode = node;
        
        // loop through the list
        // The two nodes must move at different rates
        while (firstNode.next != null && secondNode.next != null && second.next.next != null) {
            // move the first node by one
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;

            // compare the nodes
            if (firstNode == secondNode) {
                return true;
            }
        }

        // default is false
        return false;
    }

}
