package com.javainterview.app.treeInterview;

/**
 * Created on 3/20/2016.
 *
 * Given two binary trees.
 * Return true if all of their nodes are equivalent.
 *
 * Solution:
 *   Use a recursive solution.
 *   Base case where both nodes are null or either is null.
 *   Then compare their values.
 *
 *   Depth first search; post order (left, right, this)
 *   O(n)
 */
public class SameTree {

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value == root2.value) {
            // values are the same so we will compare their children
            boolean leftSame = isSameTree(root1.left, root2.left);
            boolean rightSame = isSameTree(root1.right, root2.right);

            return leftSame && rightSame;
        }

        // both values are different
        return false;
    }
}
