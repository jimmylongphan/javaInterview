package com.javainterview.app.treeInterview;


/**
 * Reverse the nodes in a binary tree
 *   4
 * 2   7
 * 
 *   4
 * 7   2
 * 
 * 
 */
public class BinaryTree {

    public Node invertTree(Node root) {
        if (root == null) {
            return null;   
        }    
        
        Node left = root.left;
        Node right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
    
}