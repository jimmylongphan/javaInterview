package com.javainterview.app.treeInterview;

/**
 * Created on 2/21/2016.
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public boolean visited = false;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public void print() {
        System.out.print(" " + value + " ");
    }

    public TreeNode getUnvisitedChild() {
        if (left != null && left.visited == false) {
            return left;
        } else if(right != null && right.visited == false) {
            return right;
        }

        return null;
    }

    public String toString() {
        return Integer.toString(value);
    }
}