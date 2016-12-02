package com.javainterview.app.treeInterview;

/**
 * Created on 2/21/2016.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public boolean visited = false;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public void print() {
        System.out.print(" " + val + " ");
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
        return Integer.toString(val);
    }
}