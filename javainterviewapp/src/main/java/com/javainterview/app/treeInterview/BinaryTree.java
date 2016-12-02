package com.javainterview.app.treeInterview;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree() {

    }

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }



    /**
     * Runtime: O(n) have to visit all nodes to verify
     * Storage: 0 not storing
     *
     * @param root starting node
     * @param min  lowest possible val
     * @param max  highest possible val
     * @return true if BST
     */
    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // check the current node
        if (root.val > max || root.val < min) {
            System.out.println(String.format("%d is > %d or < %d", root.val, max, min));
            return false;
        }

        // left child must be BST
        boolean left = isBST(root.left, min, root.val);
        if (!left) {
            return false;
        }

        System.out.println("left node is bst");

        // right child must be BST
        boolean right = isBST(root.right, root.val, max);
        System.out.println(String.format("right node is %b bst", right));

        return right;
    }


    /**
     * Insert a val into this tree.
     *
     * @param value val to add
     */
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }

        root = insert(root, value);
    }

    /**
     * Naive algorithm is to check if the val is less than or equal than the current treeNode
     * If it is less, then recursively insert left.
     * If it is greater, then recurisvely insert right.
     *
     * Always insert at a leaf position.
     *
     * Runtime: O(log n) height of tree
     * Space: O(1) new treeNode
     */
    private TreeNode insert(TreeNode treeNode, int value) {
        if (treeNode == null) {
            treeNode = new TreeNode(value);
            return treeNode;
        }

        if (value < treeNode.val) {
            treeNode.left = insert(treeNode.left, value);
        } else if (value > treeNode.val) {
            treeNode.right = insert(treeNode.right, value);
        }
        return treeNode;
    }


    /**
     * Base method to remove a node with val
     *
     * @param value val to delete
     * @return true if node was removed
     */
    public void delete(int value) {
        // we are rebuilding the tree when we delete
        root = delete(root, value);
    }

    /**
     * If there is nothing to remove then return null.
     * If the val is less, then we remove on the left.
     * Since the left side is modified, we replace our left treeNode to the new left.
     *
     * Same is applied to the right side.
     *
     * If the val matches, then we can return one of the nodes if only one of them exist.
     *
     * If there are two children, then we find the max val on the left side, then we replace
     * the current treeNode with that val. After replacing, we need to remove the maxLeft val
     * on the left side.
     *
     * Then we recursively call with that new removed val.
     *
     * Then we return the current treeNode which has been modified.
     *
     * Runtime: O(log n) or the height of the tree
     * Space:
     *
     * @param treeNode  current treeNode
     * @param value val to delete
     * @return The modified treeNode
     */
    private TreeNode delete(TreeNode treeNode, int value) {
        // no treeNode to remove
        if (treeNode == null) {
            return null;
        }

        if (value < treeNode.val) {
            // go to the left of the tree if it exists
            treeNode.left = delete(treeNode.left, value);
        } else if (value > treeNode.val) {
            treeNode.right = delete(treeNode.right, value);
        } else {
            // this is the treeNode we want to delete
            // if only left exists, then we replace the current treeNode with the left child
            if (treeNode.right == null) {
                return treeNode.left;
            } else if (treeNode.left == null) {
                // only right treeNode exists, so return right
                return treeNode.right;
            }

            // there are two children
            TreeNode temp = treeNode;

            // find the max val on the left side
            TreeNode maxLeft = findMax(treeNode.left);

            // replace the current treeNode with the maxLeft
            treeNode.val = maxLeft.val;

            // delete the maxLeft treeNode and rebuild the left
            treeNode.left = delete(temp.left, maxLeft.val);
        }

        // treeNode has been modified where its children is modified
        // or it has been removed
        return treeNode;
    }

    /**
     * Find the greatest node from this node
     *
     * Runtime: O(log n)  height of tree
     * Space: 0 not storing
     */
    public TreeNode findMax(TreeNode root) {
        if (root.right != null) {
            return findMax(root.right);
        }

        // no greater nodes so return this node
        return root;
    }

    /**
     * Printing a binary tree.
     * We will use two levels and breadth-first search.
     * One queue will be the first level and as we build our queue, the children
     * will be added to the second queue.
     *
     * We will alternate the queues in the loop.
     *
     * Runtime: O(n) we have to print every node
     * Space: O(0)  storage is temporary
     *
     * @param root starting node
     */
    public void printLevelOrder(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        // start with the root
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            for (TreeNode treeNode : currentLevel) {
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
                // print spaces between all the nodes on this level
                System.out.print(treeNode.val + " ");
            }

            // this is a new level and print a new line
            System.out.println();

            // alternate the levels
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
        }
    }

    /**
     * Runtime: O(n)  we visit every node
     * space: O(h) binary tree height
     *
     * @param root starting node
     * @param a first node to find
     * @param b second node to find
     * @return TreeNode if it exists
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        // once the nodes match, then we know that a or b is a descendant of
        // the original root
        if (root.val == a.val || root.val == b.val) {
            return root;
        }

        // recursively find ancestor for both children
        TreeNode leftCommon = lowestCommonAncestor(root.left, a, b);
        TreeNode rightCommon = lowestCommonAncestor(root.right, a, b);

        if (leftCommon != null && rightCommon != null) {
            // original root is the common ancestor of both
            return root;
        }

        // there is a descendant on the left branch
        if (leftCommon != null) {
            return leftCommon;
        } else if (rightCommon != null) {
            // there is a descendant on right branch
            return rightCommon;
        }

        // there are no descendants at all
        return null;
    }
}