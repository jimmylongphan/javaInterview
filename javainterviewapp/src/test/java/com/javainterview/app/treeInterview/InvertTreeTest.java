package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

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