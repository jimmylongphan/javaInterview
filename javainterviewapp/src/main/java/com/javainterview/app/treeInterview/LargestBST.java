package com.javainterview.app.treeInterview;


/**
 * Company: Microsoft
 *
 * Given a binary tree, find the largest subtree which is a
 * binary search tree.
 *
 * The result includes the node and all of its children.
 *
 * The return value is the size of the BST
 *
 * Solution:
 * Runtime: O(n)
 * We go bottom-up using depth first search.
 */
public class LargestBST {

    /**
     * Class that contains the result of a binary search tree
     */
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

    /**
     * @param root root to find the bst
     * @return size of the largest bst
     */
    public int largestBSTSubtree(Node root) {
        Result res = BSTSubtree(root);

        // return the size of the BST
        return Math.abs(res.res);
    }

    /**
     * @param root root to find bst
     * @return result object which contains the root of the bst and its min and max values
     */
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
                root.value < left.max || root.value > right.min) {

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
            // also includes leaf nodes which are bst
            int maxSize = left.res + right.res + 1;

            // set the new min and max values
            int minVal = Math.min(root.value, left.min);
            int maxVal = Math.max(root.value, right.max);

            // return a proper BST result
            return new Result(maxSize, minVal, maxVal);
        }
    }
}