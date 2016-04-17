package com.javainterview.app.treeInterview;

/**
 * Company: Facebook
 * Tags: Trees
 * Depth first search
 * 
 * Problem 1: medium
 * Given a root node.
 * Populate each node with its right node.
 * If there is no right node, then set to null.
 * 
 * Solution: O(n)
 * 
 * Problem 2: hard
 * Tree may not be perfect.
 * Nodes may be missing for siblings
 * 
 */
public class NextNode {
    
    public void connect(TreeNode root) {
        // start at the root
        TreeNode levelStart = root;
        while( levelStart != null) {
            
            // rest current to the leftmost of this level
            TreeNode current = levelStart;
            
            // loop through all the current nodes on this level
            while(current != null) {
                // if left child exists,
                // set its next to the right child
                if( current.left != null) {
                    current.left.next = current.right;
                }
                // if right child exists and sibling exists
                // set the right child next to the siblings left
                if( current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                
                // loop through the sibling node
                current = current.next;
            }
            
            // go to next level which is the left child
            levelStart = levelStart.left;
        }
    }
    
    
    public void connectImperfect(TreeNode root) {
        TreeNode head = null;
        TreeNode pre = null;
        TreeNode current = root;
        
        
        while( current != null ) {
            
            // iterate on current level
            while( current != null) {
                // set for left child
                if( current.left != null) {
                    if ( pre != null) {
                        pre.next = current.left;
                    } else {
                        head = current.left;
                    }
                    pre = current.left;
                }
                
                // set for right child
                if (current.right != null) {
                    if( pre != null) {
                        pre.next = current.right;
                    } else {
                        head = current.right;
                    }
                    pre = current.right;
                }
                
                // move to next node in this level
                current = current.next;
            }
            
            // move to next level
            current = head;
            head = null;
            pre = null;
        }
    }
}