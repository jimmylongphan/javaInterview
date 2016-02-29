package com.javainterview.app.ListInterview;

/**
 * Created on 2/28/2016.
 *
 * Given a list, determine if there is a cycle in the list.
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
        ListNode firstNode = node;
        ListNode secondNode = node;

        // boundary checking
        if (node == null) {
            return false;
        }

        // loop through the list
        // The two nodes must move at different rates
        while (secondNode != null) {
            // move the first node by one
            firstNode = firstNode.next;

            // move the second node by two if possible
            if (secondNode.next != null) {
                secondNode = secondNode.next.next;
            } else {
                // reached the end, there is no cycle
                return false;
            }

            // compare the nodes
            if (firstNode == secondNode) {
                return true;
            }
        }

        // default is false
        return false;
    }

}
