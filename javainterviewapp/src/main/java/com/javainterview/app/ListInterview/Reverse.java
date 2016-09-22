package com.javainterview.app.ListInterview;

/**
 * LeetCode: 206
 * Company: All
 * Tags: Linked List
 *
 * Created on 9/28/2015.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class Reverse {
    
    /**
     * @param head head of the list to reverse
     * 
     */
    public ListNode reverseList(ListNode head) {
        // new head of the reversed list
        ListNode pre = null;
        
        // loop through current node
        while (head != null) {
            // get the next node
            ListNode next = head.next;
            
            // next points to previous
            head.next = pre;
            
            // increment previous to head
            pre = head;
            
            // increment head to next
            head = next;
        }
        
        // return the new head, which is reversed
        return pre;
    }
}
