package com.javainterview.app.treeInterview;

/**
 * Created on 2/28/2016.
 */
public class BalanceTree {

    /**
     * Method to retrieve the height of the tree
     * Recursively get the height from left or right child.
     * Count this level so add 1.
     *
     * @param root starting node
     * @return height of tree
     */
    public int checkHeight(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // check if left is balanced
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        // check if right is balanced
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        // check if current node is balanced
        // it is not balanced if the left and right children differ by more than 1
        int heightDiff = leftHeight - rightHeight;
        if ( Math.abs(heightDiff) > 1) {
            return -1;
        }

        // return the height of the children plus this level
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Check if this tree is balanced
     *
     * @param root
     * @return true if balanced
     */
    public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        }

        return true;
    }

}
