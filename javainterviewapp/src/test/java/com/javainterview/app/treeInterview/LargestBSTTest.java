package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 4/16/2016.
 */
public class LargestBSTTest {

    @Test
    public void testLargestBSTSubtree() throws Exception {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);

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