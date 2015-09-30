package com.javainterview.app.treeInterview;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/30/2015.
 */
public class BinaryTreeTest {

    BinaryTree binaryTree;

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("testBeforeSuite() creating BinaryTree");
        binaryTree = new BinaryTree();
    }

    @Test
    public void checkSmall() {
        BinaryTree.Node node = binaryTree.new Node();
        node.value = 50;
        node.left = binaryTree.new Node();
        node.left.value = 25;
        node.right = binaryTree.new Node();
        node.right.value = 75;

        boolean isBST = binaryTree.isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

        assertTrue(isBST);
    }

    @Test
    public void negTest() {
        BinaryTree.Node node = binaryTree.new Node();
        node.value = 50;
        node.left = binaryTree.new Node();
        node.left.value = 75;

        boolean isBST = binaryTree.isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

        assertFalse(isBST);
    }

    @Test
    public void testInsert() throws Exception {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);
        assertTrue(bt.isBST(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testDelete() throws Exception {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);

        bt.delete(75);
        BinaryTree.Node max = bt.findMax(bt.root);
        assertEquals(max.value, 50);
    }

    @Test
    public void testFindMax() throws Exception {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);

        BinaryTree.Node max = bt.findMax(bt.root);
        assertEquals(max.value, 75);
    }

    @Test
    public void testPrintLevelOrder() throws Exception {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);
        bt.printLevelOrder(bt.root);
    }

    @Test
    public void testLowestCommonAncestor() {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);

        BinaryTree.Node common = bt.lowestCommonAncestor(bt.root,
                bt.new Node(25), bt.new Node(75));
        assertEquals(common.value, 50);
    }
}