package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 2/29/2016.
 */
public class BalanceTreeTest {

    /**
     *           1
     *        2    5
     *      3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testIsBalanced() throws Exception {
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

        BalanceTree bt = new BalanceTree();
        Assert.assertTrue(bt.isBalanced(one));
    }

    /**
     *           1
     *        2    3
     *      4  5
     *    6
     *
     * @throws Exception
     */
    @Test
    public void testIsBalanced2() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;

        BalanceTree bt = new BalanceTree();
        Assert.assertFalse(bt.isBalanced(one));
    }
}