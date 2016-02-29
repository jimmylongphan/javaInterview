package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;

        BalanceTree bt = new BalanceTree();
        Assert.assertFalse(bt.isBalanced(one));
    }
}