package com.javainterview.app.ListInterview;


/**
 * Company:
 * Amazon, LinkedIn, Microsoft
 * 
 * Merge two sorted linked lists and return a new list
 * 
 * Solution:
 * 
 * Compare each node from list1 and list2
 * If one of the nodes is null, then return the other
 * For the smaller node, it will be near the beginning of the list
 *   Then we set the next value for the smaller node
 *   by recursively calling merge with smallNode.next and the other node.
 * 
 * 
 * Runtime complexity:
 * list1.length + list2.length
 * O(list1.length + list2.length)
 * recursive call for every node
 * 
 * Space complexity:
 * Also O(list1.length + list2.length)
 * We are calling the stack for every node
 * 
 */
public class MergeTwoLists {
    
    public ListNode mergeTwoLists( ListNode node1, ListNode node2 ) {
        // check for null nodes
        // Then return the other node
        if( node1 == null ) {
            return node2;
        }
        if( node2 == null ) {
            return node1;
        }
        
        // If node1 is smaller, then we will put it near the
        // beginning of the list
        // and the next node shall be the smaller of 
        // node1.next or node2
        if( node1.value < node2.value ) {
            node1.next = mergeTwoLists(node1.next, node2);
            
            // return the result of the merge
            return node1;
        } else {
            // node2 is less than or equal to node1
            // so node2 should be in the beginning of the list
            // node2 next should point to the smaller of
            // node1 or node2.next
            node2.next = mergeTwoLists(node1, node2.next);
            
            // return the result of the merge
            return node2;
        }
    }
}