package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class InvertTreeTest {

    /**
     * 1
     * 2    5
     * 3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testInvertTree() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.left = six;
        five.right = seven;

        InvertTree it = new InvertTree();
        it.invertTree(one);

        Assert.assertEquals(one.left, five);
        Assert.assertEquals(five.right, six);
    }
}