package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 3/6/2016.
 */
public class MaxSubTreeTest {

    @Test
    public void testGetMaxSubtree() throws Exception {
        TreeNode one = new TreeNode(-1);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(10000000);

        one.left = two;
        one.right = three;

        MaxSubTree mst = new MaxSubTree();
        TreeNode maxSubtree = mst.getMaxSubtree(one);

        // Should return the right child
        Assert.assertEquals(maxSubtree, three);
    }

    @Test
    public void testGetMaxSubtree2() throws Exception {
        TreeNode one = new TreeNode(-10);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(-1);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(-1);
        TreeNode seven = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        MaxSubTree mst = new MaxSubTree();
        TreeNode maxSubtree = mst.getMaxSubtree(one);

        // Should return the right child
        Assert.assertEquals(maxSubtree, two);
    }

}