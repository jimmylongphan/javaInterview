package com.javainterview.app.treeInterview;


import java.util.*;

/**
 * Company Tag: Facebook
 * 
 * Given a binary tree, return the vertical order of the nodes.
 * It goes left to right, and top to bottom.
 * So the leftmost node is printed first.
 * The top root is in the middle.
 * 
 * Solution:
 *   BreadthFirstSearch
 *   O(n):  we visit all nodes
 * 
 *  The return val will be a list of columns.
 *  The columns will be in order from left to right, top to bottom.
 * 
 *  We will keep a map of a column and the node values that belong in that column.
 * 
 *  We will maintain a queue for nodes because this is BFS.
 *  We will maintain another queue to keep track of the column the current node is in.
 * 
 * Initialize the queue with the root.
 * Initialize the column queue with column 0, because root is near the middle.
 * 
 * Loop through queue
 *   Retrieve the current column of the node
 *   Check if our map has this column or not.
 *     If not, then add new entry into map with column number and a new Integer array
 *   Using the current column as key - add the current node into that array in the map.
 * 
 *   Visit the left node
 *     Add the left node to the queue
 *     Left node is decremented column val
 *     Add that new column val into the column queue
 *     Keep track of leftmost column val
 * 
 *   Visit the right node
 *     Add the right node to the queue
 *     Right node is decremented column val
 *     Add that new column val into the column queue
 *     Keep track of the rightmost column val
 * 
 *  Loop through all the columns in the map from leftmost to rightmost
 *    Add the array values into the result list
 * 
 *  Return the result list
 */
public class VerticalOrder {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // error check
        if (root == null) {
            return result;
        }

        Map<Integer, ArrayList<Integer>> columnNodeMap = new HashMap<Integer, ArrayList<Integer>>();

        // Implementing breadth-first-search and we are using
        // a queue
        Queue<TreeNode> treeNodeQ = new LinkedList<TreeNode>();

        // this variable keeps track of which column the node belongs to
        Queue<Integer> columnQ = new LinkedList<Integer>();

        treeNodeQ.add(root);
        // the root node belongs to column 0
        columnQ.add(0);

        int min = 0, max = 0;
        while (!treeNodeQ.isEmpty()) {
            TreeNode currentTreeNode = treeNodeQ.poll();

            // get the current column val
            int column = columnQ.poll();

            // check if we are keeping track of this column
            if (!columnNodeMap.containsKey(column)) {
                columnNodeMap.put(column, new ArrayList<Integer>());
            }

            // add this node to the current column array
            columnNodeMap.get(column).add(currentTreeNode.val);

            // left children are one column to the left
            if (currentTreeNode.left != null) {
                // add the child to the queue
                treeNodeQ.add(currentTreeNode.left);

                // left child is one column to the left
                int leftColumnNum = column - 1;
                columnQ.add(leftColumnNum);

                // keep track of the leftmost column
                if (column <= min) {
                    min = leftColumnNum;
                }
            }

            // right children are one column to the right
            if (currentTreeNode.right != null) {
                // add the child to the queue
                treeNodeQ.add(currentTreeNode.right);
                // right child is one column to the right
                int rightColumnNum = column + 1;
                columnQ.add(rightColumnNum);

                // keep track of the rightmost column
                if (column >= max) {
                    max = rightColumnNum;
                }
            }
        }  // end-while

        // loop through all the columns from left to right
        for (int i = min; i <= max; i++) {
            // add the array of nodes to the result
            // in the order from left to right
            result.add(columnNodeMap.get(i));
        }

        return result;
    }
}
