package com.javainterview.app.ListInterview;

/**
 * Created on 9/30/2015.
 */
public class DoublyLinkedList {

    ListNode head;

    /**
     * This method does 2 things
     * First it reverse the list recursively.
     * Also, it creates a copy so the original node is not modified.
     *
     * @param node node to reverse
     * @return the modified node
     */
    public ListNode reverseRecursive(ListNode node) {
        if (node == null) {
            return null;
        }

        // we reached the end
        if (node.next == null) {
            head = node;
            // this the new start
            node.pre = null;
            return node;
        }

        // have not reached the end so we can continue
        ListNode next = node.next;

        // after retrieve the next node, unlink it
        node.next = null;

        // reverse everything in new node;
        ListNode reversedNextNode = reverseRecursive(next);

        // join the two lists
        reversedNextNode.next = node;

        // the currents node previous is now points to next
        node.pre = reversedNextNode;

        // return the modified node
        return node;
    }


    /**
     * We only operate on the current node.
     * Modify the two references the current node is using.
     *
     * Then increment the node.
     * Also increment the head since it will be moving.
     *
     * @param node Starting node to reverse
     */
    public void reverseList(ListNode node) {
        ListNode current = node;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = current.pre;
            current.pre = next;

            this.head = current;
            current = next;
        }
    }

    /**
     * Reverse the list with a new copy
     *
     * @param node node to reverse
     * @return a copied and reversed list
     */
    public ListNode reverseListCopy(ListNode node) {
        ListNode current = new ListNode(node);
        ListNode next;
        ListNode newHead = null;

        while (current != null) {
            next = current.next;
            if (next != null) {
                next = new ListNode(current.next);
                next.pre = current;
            }
            current.next = current.pre;
            current.pre = next;

            newHead = current;
            current = next;
        }
        return newHead;
    }


    /**
     * Insert a node after a desired position
     *
     * @param node new node
     * @param pos  position to insert afterwards
     */
    public void insertAfterPos(ListNode node, int pos) {
        if (head == null) {
            head = node;
            return;
        }

        ListNode current = head;
        for (int i = 0; current != null; i++) {
            if (i == pos) {
                node.pre = current;
                node.next = current.next;

                ListNode next = current.next;
                if (next != null) {
                    next.pre = node;
                }
                current.next = node;
                break;
            }
            current = current.next;
        }
    }


    /**
     * Find the node at the position to delete.
     * Loop until we find the desired node.
     * If it exists, the modify the references of the pre and next.
     *
     * @param pos position to delete
     */
    public ListNode deleteAtPos(int pos) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        for (int i = 0; current != null; i++) {
            if (i == pos) {
                ListNode pre = current.pre;
                ListNode next = current.next;

                if (pre != null) {
                    pre.next = next;
                }
                if (next != null) {
                    next.pre = pre;
                }

                // reset references
                current.pre = null;
                current.next = null;
                return current;
            }
            current = current.next;
        }

        return null;
    }


    /**
     * Print the nodes in the list
     */
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Get the node at position
     *
     * @param pos position to get
     * @return node
     */
    public ListNode getNode(int pos) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            if (count == pos) {
                return current;
            }
            current = current.next;
            count++;
        }

        return null;
    }
}
