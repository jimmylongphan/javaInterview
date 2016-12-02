package com.javainterview.app.treeInterview;


import java.util.HashMap;
import java.util.Map;

/**
 * Created on 3/6/2016.
 * Twitch
 *
 * Given a binary tree root node.
 * Find the subtree with the largest sum.
 *
 * The tree can include positive and negative numbers.
 * The root is included in the subtree.
 *
 */
public class MaxSubTree {

    /**
     * Public method to access the node.
     *
     * @param root
     * @return
     */
    public TreeNode getMaxSubtree(TreeNode root) {
        TreeNode result;
        Map<TreeNode, Integer> nodeSumMap = new HashMap<TreeNode, Integer>();

        result = getMaxSubtreeRecursive(root, nodeSumMap);
        return result;
    }

    /**
     * Find the node that contains the maximum sum.
     *
     * @param root TreeNode to start the search
     * @return the node with the highest val
     */
    protected TreeNode getMaxSubtreeRecursive(TreeNode root, Map<TreeNode,Integer> nodeSumMap) {
        if (root==null) {
            return null;
        }

        // traverse the tree and calculate all the sums
        // depth first search
        TreeNode maxLeft = getMaxSubtreeRecursive(root.left, nodeSumMap);
        TreeNode maxRight = getMaxSubtreeRecursive(root.right, nodeSumMap);

        // get the sums associated with the children
        Integer leftSum = nodeSumMap.get(root.left);
        if (leftSum == null) {
            leftSum = 0;
        }
        Integer rightSum = nodeSumMap.get(root.right);
        if (rightSum == null) {
            rightSum = 0;
        }

        // calculate the current sum and store it
        int currentSum = root.val + leftSum + rightSum;
        nodeSumMap.put(root, currentSum);

        // retrieve the sums associated with max left node and max right node
        Integer maxLeftSum = nodeSumMap.get(maxLeft);
        if (maxLeftSum == null) {
            maxLeftSum = 0;
        }
        Integer maxRightSum = nodeSumMap.get(maxRight);
        if (maxRightSum == null) {
            maxRightSum = 0;
        }

        // return the node that contains the highest sum
        if (currentSum > maxLeftSum && currentSum > maxRightSum) {
            return root;
        } else if ( maxLeftSum > maxRightSum ) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }



}
