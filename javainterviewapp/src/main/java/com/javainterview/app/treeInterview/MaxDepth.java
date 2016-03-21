package com.javainterview.app.treeInterview;

/**
 * Created on 3/20/2016.
 *
 * Given a binary tree, find its maximum depth
 *
 * Solution:
 *   Use depth first search.
 *   Keep track of the left and right depths.
 *   Take the larger depth and add 1 for the current depth
 */
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
