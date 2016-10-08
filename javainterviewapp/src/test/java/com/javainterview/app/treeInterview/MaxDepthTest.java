package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 3/20/2016.
 */
public class MaxDepthTest {

    /**
     *     1
     *   2    5
     * 3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testMaxDepth() throws Exception {
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

        MaxDepth md = new MaxDepth();
        int result = md.maxDepth(one);
        Assert.assertEquals(result, 3);
    }
}