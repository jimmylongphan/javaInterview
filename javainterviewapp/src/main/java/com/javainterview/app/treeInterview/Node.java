package com.javainterview.app.treeInterview;

/**
 * Created on 2/21/2016.
 */
public class Node {
    public int value;
    public Node left;
    public Node right;
    public boolean visited = false;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public void print() {
        System.out.print(" " + value + " ");
    }

    public Node getUnvisitedChild() {
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