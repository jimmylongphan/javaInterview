package com.javainterview.app.treeInterview;

public class BinaryTree {

    public Node root;
    
    public BinaryTree(int value) {
        root = new Node(value);
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int value) {
            this.value = value;
        }
    }

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
     * Naive algorithm is to check if the value is less than or equal than the current node
     * If it is less, then recursively insert left.
     * If it is greater, then recurisvely insert right.
     * 
     * Always insert at a leaf position.
     */
    public Node insert(Node root, int value) {
        if( root == null ) {
            root = new Node(value);
            return root;
        }
        
        if( value < root.value ) {
            root.left = insert(root.left, value);
        } else if ( value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public boolean delete(Node root, int value) {
        if ( root == null ) {
            return false;
        }
        
        if( value < root.value ) {
            delete( root.left, value );
        } else if ( value > root.value ) {
            delete( root.right, value);
        } else {
            // handle 2 children case
            if( root.left != null && root.right != null) {
                // find the greatest child on the left side
                Node maxLeft = findMax(root.left);
                
                // replace the current value with the max from left
                root.value = maxLeft.value;
                
                // Remove the Node that we just put in this position
                delete(maxLeft.value, root.left);
            } else if(root.left != null) {
                // handle left child
                Node throwaway = root;
                
                // replace the current node with left
                root = root.left;
                throwaway = null;
            } else if( root.right != null) {
                // handle right child
                Node throwaway = root;
                
                // replace current node with right
                root = root.right;
                throwaway = null;
            } else {
                // no children so just remove node
                root = null;
            }
        }
    }

    /**
     * Find the greatest node from this node
     */
    public Node findMax(Node root) {
        if( root.right != null ) {
            return findMax(root.right);
        }
        
        // no greater nodes so return this node
        return root;
    }
}