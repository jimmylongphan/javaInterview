package com.javainterview.app.treeInterview;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public BinaryTree() {

    }

    public BinaryTree(int value) {
        root = new Node(value);
    }



    /**
     * Runtime: O(n) have to visit all nodes to verify
     * Storage: 0 not storing
     *
     * @param root starting node
     * @param min  lowest possible value
     * @param max  highest possible value
     * @return true if BST
     */
    public boolean isBST(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // check the current node
        if (root.value > max || root.value < min) {
            System.out.println(String.format("%d is > %d or < %d", root.value, max, min));
            return false;
        }

        // left child must be BST
        boolean left = isBST(root.left, min, root.value);
        if (!left) {
            return false;
        }

        System.out.println("left node is bst");

        // right child must be BST
        boolean right = isBST(root.right, root.value, max);
        System.out.println(String.format("right node is %b bst", right));

        return right;
    }


    /**
     * Insert a value into this tree.
     *
     * @param value value to add
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }

        root = insert(root, value);
    }

    /**
     * Naive algorithm is to check if the value is less than or equal than the current node
     * If it is less, then recursively insert left.
     * If it is greater, then recurisvely insert right.
     *
     * Always insert at a leaf position.
     *
     * Runtime: O(log n) height of tree
     * Space: O(1) new node
     */
    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }


    /**
     * Base method to remove a node with value
     *
     * @param value value to delete
     * @return true if node was removed
     */
    public void delete(int value) {
        // we are rebuilding the tree when we delete
        root = delete(root, value);
    }

    /**
     * If there is nothing to remove then return null.
     * If the value is less, then we remove on the left.
     * Since the left side is modified, we replace our left node to the new left.
     *
     * Same is applied to the right side.
     *
     * If the value matches, then we can return one of the nodes if only one of them exist.
     *
     * If there are two children, then we find the max value on the left side, then we replace
     * the current node with that value. After replacing, we need to remove the maxLeft value
     * on the left side.
     *
     * Then we recursively call with that new removed value.
     *
     * Then we return the current node which has been modified.
     *
     * Runtime: O(log n) or the height of the tree
     * Space:
     *
     * @param node  current node
     * @param value value to delete
     * @return The modified node
     */
    private Node delete(Node node, int value) {
        // no node to remove
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            // go to the left of the tree if it exists
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // this is the node we want to delete
            // if only left exists, then we replace the current node with the left child
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                // only right node exists, so return right
                return node.right;
            }

            // there are two children
            Node temp = node;

            // find the max value on the left side
            Node maxLeft = findMax(node.left);

            // replace the current node with the maxLeft
            node.value = maxLeft.value;

            // delete the maxLeft node and rebuild the left
            node.left = delete(temp.left, maxLeft.value);
        }

        // node has been modified where its children is modified
        // or it has been removed
        return node;
    }

    /**
     * Find the greatest node from this node
     *
     * Runtime: O(log n)  height of tree
     * Space: 0 not storing
     */
    public Node findMax(Node root) {
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
    public void printLevelOrder(Node root) {
        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        // start with the root
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            for (Node node : currentLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                // print spaces between all the nodes on this level
                System.out.print(node.value + " ");
            }

            // this is a new level and print a new line
            System.out.println();

            // alternate the levels
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();
        }
    }

    /**
     * Runtime: O(n)  we visit every node
     * space: O(h) binary tree height
     *
     * @param root starting node
     * @param a first node to find
     * @param b second node to find
     * @return Node if it exists
     */
    public Node lowestCommonAncestor(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }

        // once the nodes match, then we know that a or b is a descendant of
        // the original root
        if (root.value == a.value || root.value == b.value) {
            return root;
        }

        // recursively find ancestor for both children
        Node leftCommon = lowestCommonAncestor(root.left, a, b);
        Node rightCommon = lowestCommonAncestor(root.right, a, b);

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