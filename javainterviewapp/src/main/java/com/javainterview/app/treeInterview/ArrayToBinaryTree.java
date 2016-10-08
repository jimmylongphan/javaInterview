package com.javainterview.app.treeInterview;

/**
 * TODO test
 * LeetCode 108
 *
 * Company: Airbnb
 *
 * Tags: Tree, Depth-first Search
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 *
 * To maintain the binary search tree balance.
 * There should be similar count of left and right nodes.
 * This means the current node is in the middle.
 * So while building the tree recursively, we will choose the middle of
 * the current section as the new node.
 *
 * Created on 10/8/2016.
 */
public class ArrayToBinaryTree {

    /**
     * Use a helper method. This will call it with starting points
     *
     * @param nums sorted array
     * @return The root of the new balance tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }


    /**
     *
     * @param nums original sorted array
     * @param low the beginning of the section
     * @param high the end of the section
     * @return newly constructed node for binary search tree
     *
     */
    public TreeNode helper(int[] nums, int low, int high) {
        // base case
        if (low > high) {
            return null;
        }

        // get the new node to add into the tree
        // to maintain balance, we use the middle node
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, low, mid -1);
        node.right = helper(nums, mid+1, high);
        return node;
    }


}
