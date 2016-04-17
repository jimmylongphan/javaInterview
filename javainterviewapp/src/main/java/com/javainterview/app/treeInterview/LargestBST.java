package com.javainterview.app.treeInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Company: Microsoft
 * 
 * Given a binary tree, find the largest subtree which is a 
 * binary search tree.
 * 
 * The result includes the node and all of its children.
 * 
 * The return value is the size of the BST
 */
public class LargestBST {
    class Result {
        // the sign of res indicates if this result is a bst or not
        int res;
        int min;
        int max;
        
        /**
         * @param res the size of this tree
         * @param min the minimum value of this tree
         * @param max the maximum value of this tree
         */
        public Result(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }
    
    
    public int largestBSTSubtree(Node root) {
        Result res = BSTSubtree(root);
        
        // return the size of the BST
        return Math.abs(res.res);
    }
    
    protected Result BSTSubtree(Node root) {
        // if we are at a null node
        // then return dummy result
        if (root == null) {
            // dummy node will have size 0
            // minimum value is MAX
            // maximum value is MIN
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        // get the bst from the left child
        Result left = BSTSubtree(root.left);
        
        // get the bst from the right child
        Result right = BSTSubtree(root.right);
        
        // check if either children is not a BST, from the signs
        // or if roots value does not satisfy BST
        if (left.res < 0 || right.res < 0 ||
            root.val < left.max || root.val > right.min) {
        
            // convert the size value to absolute value
            int leftSize = Math.abs(left.res);
            int rightSize = Math.abs(right.res);
            
            // get the max of the sizes
            int maxSize = Math.max(leftSize, rightSize);

            // return a result with negative sign of size
            // and irrelevant min and max
            return new Result(maxSize * -1, 0, 0);
        } else {
            // all conditions for bst passed
            // include root node
            // also includes leaf nodes
            int maxSize = left.res + right.res + 1;
            
            // set the new min and max values
            int minVal = Math.min(root.val, left.min);
            int maxVal = Math.max(root.val, right.max);
            
            // return a proper BST result
            return new Result(maxSize, minVal, maxVal);
        }
    }
}