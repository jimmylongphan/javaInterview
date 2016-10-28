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
 */
public class NextNode {

    /**
     * Uses depth first search to set the next pointer
     * This works for perfect shaped trees
     *
     * @param root starting node
     */
    public void connect(TreeNode root) {
        // start at the root
        TreeNode levelStart = root;
        while (levelStart != null) {

            // rest current to the leftmost of this level
            TreeNode current = levelStart;

            // loop through all the current nodes on this level
            while (current != null) {
                // if left child exists,
                // set its next to the right child
                if (current.left != null) {
                    current.left.next = current.right;
                }
                // if right child exists and sibling exists
                // set the right child next to the siblings left
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                // loop through the sibling node horizontally
                current = current.next;
            }

            // go down next level which is the left child
            levelStart = levelStart.left;
        }
    }


    /**
     * Similar problem, but the trees may be imperfect.
     *
     * @param root starting node
     */
    public void connectImperfect(TreeNode root) {
        // leftmost node in lower level
        TreeNode leftMost = null;
        // previous node in lower level
        TreeNode pre = null;
        // current node in upper level
        TreeNode current = root;

        while (current != null) {

            // iterate on current level
            while (current != null) {
                // set for left child
                if (current.left != null) {
                    if (pre != null) {
                        // pre node on lower level is not null
                        // so we can set it to the right child
                        pre.next = current.left;
                    } else {
                        // pre is null so we can set the leftmost node on lower level
                        leftMost = current.left;
                    }
                    // update the lower level node to left child
                    pre = current.left;
                }

                // set for right child
                if (current.right != null) {
                    if (pre != null) {
                        // pre node on lower level is not null
                        // so we can set it to the right child
                        pre.next = current.right;
                    } else {
                        // pre is null so we know this is the leftmost node on the lower level
                        leftMost = current.right;
                    }
                    // update pre to be the next child on this level
                    pre = current.right;
                }

                // move to next node in this level horizontally
                current = current.next;
            }

            // move to next level
            current = leftMost;
            // reset because we are going to next level
            leftMost = null;
            pre = null;
        }
    }
}