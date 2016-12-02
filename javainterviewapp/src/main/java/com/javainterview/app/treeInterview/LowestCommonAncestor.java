package com.javainterview.app.treeInterview;

/**
 * LeetCode 235
 *
 * Created on 12/1/2016.
 *
 * Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * Company: Amazon, Microsoft, Facebook, Twitter
 * Tags: Trees
 *
 * O(height of tree)
 *
 * ----------------------------
 *
 * LeetCode 236
 *
 * Company: Amazon, LinkedIn, Apple, Facebook, Microsoft
 * Tags: Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * In this problem, the nodes are not sorted and can be anywhere
 *
 * O(height of tree) + O(height of tree)
 *
 */
public class LowestCommonAncestor {

    /**
     * If both nodes are greater, then the root is too small.
     * If both nodes are less, then the root is too large
     *
     * return when correct value is reached.
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // if root is less than both nodes, then go right
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }

        // if root is greater than both nodes, then go left
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }

        // root is within accepted values
        return root;
    }

    /**
     * To find the LCA, we check if the two nodes are children of the current root.
     *
     * If not found, then check if the left or right child contains the two nodes as their children.
     *
     * If both are found, then return root.
     * If only one is found, then return the node that contains the targeted node
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // if root is null, also returns null
            return root;
        }

        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        // found our ancestor
        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }

        // return the node that found the descendant
        if (leftAncestor != null) {
            return leftAncestor;
        }

        // can be found or null
        return rightAncestor;
    }

}
