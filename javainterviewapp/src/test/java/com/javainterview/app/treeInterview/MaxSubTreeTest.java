package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/6/2016.
 */
public class MaxSubTreeTest {

    @Test
    public void testGetMaxSubtree() throws Exception {
        Node one = new Node(-1);
        Node two = new Node(1);
        Node three = new Node(10000000);

        one.left = two;
        one.right = three;

        MaxSubTree mst = new MaxSubTree();
        Node maxSubtree = mst.getMaxSubtree(one);

        // Should return the right child
        Assert.assertEquals(maxSubtree, three);
    }

    @Test
    public void testGetMaxSubtree2() throws Exception {
        Node one = new Node(-10);
        Node two = new Node(2);
        Node three = new Node(-1);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(-1);
        Node seven = new Node(5);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        MaxSubTree mst = new MaxSubTree();
        Node maxSubtree = mst.getMaxSubtree(one);

        // Should return the right child
        Assert.assertEquals(maxSubtree, two);
    }

}