package com.javainterview.app.ListInterview;

/**
 * Company:
 * LinkedIn, Google, Uber, Airbnb, Facebook, Twitter, Amazon, Microsoft
 *
 * Problem:
 * Merge k sorted Linked lists and return as one sorted list
 *
 * Time complexity:
 * O(n log k)
 * k is number of lists
 * n is total number of nodes
 */
public class MergeKLists {

    /**
     * @param lists all lists to merge
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    /**
     * @param lists  all lists to merge
     * @param index1 index of list 1 to merge
     * @param index2 index of list 2 to merge
     * @return
     */
    protected ListNode mergeLists(ListNode[] lists, int index1, int index2) {

        // passed the boundary
        if (index2 < index1) {
            return null;
        }

        // indexes have collided
        // return the second index
        if (index1 == index2) {
            return lists[index2];
        }

        // get the middle position
        int mid = (index1 + index2) / 2;

        // merge the left half of the lists
        ListNode a = mergeLists(lists, index1, mid);

        // merge the right half of the lists
        ListNode b = mergeLists(lists, mid + 1, index2);

        // create a running node
        ListNode mergeHead = new ListNode(0);
        ListNode current = mergeHead;

        // loop through lists and a b
        while (a != null && b != null) {
            // if the node in a is smaller
            // add it into the merged list
            // increment a to next node
            if (a.compareTo(b) == -1) {
                current.next = a;
                a = a.next;
            } else {
                // node b is smaller
                // add it to the current merged list
                // increment b to next node
                current.next = b;
                b = b.next;
            }
            // we added the next node to current
            // increment the current node
            current = current.next;
        }

        // for leftover nodes
        // check which one is not null 
        // and add it as next
        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        // return the merged list
        // mergeHead(0) is a dummy node so we return the next
        return mergeHead.next;
    }

}