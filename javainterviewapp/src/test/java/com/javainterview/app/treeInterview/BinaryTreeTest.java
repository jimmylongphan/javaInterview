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
        TreeNode treeNode = new TreeNode();
        treeNode.val = 50;
        treeNode.left = new TreeNode();
        treeNode.left.val = 25;
        treeNode.right = new TreeNode();
        treeNode.right.val = 75;

        boolean isBST = binaryTree.isBST(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE);

        assertTrue(isBST);
    }

    @Test
    public void negTest() {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 50;
        treeNode.left = new TreeNode();
        treeNode.left.val = 75;

        boolean isBST = binaryTree.isBST(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE);

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
        TreeNode max = bt.findMax(bt.root);
        assertEquals(max.val, 50);
    }

    @Test
    public void testFindMax() throws Exception {
        BinaryTree bt = new BinaryTree(50);
        bt.insert(25);
        bt.insert(75);

        TreeNode max = bt.findMax(bt.root);
        assertEquals(max.val, 75);
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

        TreeNode common = bt.lowestCommonAncestor(bt.root,
                new TreeNode(25), new TreeNode(75));
        assertEquals(common.val, 50);
    }
}