package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 4/16/2016.
 */
public class LargestBSTTest {

    @Test
    public void testLargestBSTSubtree() throws Exception {
        Node ten = new Node(10);
        Node five = new Node(5);
        Node fifteen = new Node(15);
        Node one = new Node(1);
        Node eight = new Node(8);
        Node seven = new Node(7);

        ten.left = five;
        ten.right = fifteen;
        five.left = one;
        five.right = eight;
        fifteen.right = seven;

        LargestBST l = new LargestBST();
        int size = l.largestBSTSubtree(ten);
        Assert.assertEquals(size, 3);
    }
}