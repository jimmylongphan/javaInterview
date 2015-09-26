package com.javainterview.app.treeInterview;

public class BinaryTree {

    public class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public boolean isBST( Node root, Integer min, Integer max) {
        if ( root == null ) {
            return true;
        }
        
        // check the current node
        if ( root.value > max || root.value < min ) {
            System.out.println( String.format("%d is > %d or < %d", root.value, max, min) );
            return false;
        }
        
        // left child must be BST
        boolean left = isBST( root.left, min, root.value );
        if ( !left ) {
            return false;
        }
        
        System.out.println( "left node is bst" );

        // right child must be BST
        boolean right = isBST( root.right, root.value, max);
        System.out.println( String.format("right node is %b bst", right) );
        
        return right;
    }
}