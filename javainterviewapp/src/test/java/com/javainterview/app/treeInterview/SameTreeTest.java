package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 3/20/2016.
 */
public class SameTreeTest {

    /**
     *     1
     *   2    5
     * 3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testIsSameTree() throws Exception {
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

        SameTree st = new SameTree();
        boolean result = st.isSameTree(one, one);
        Assert.assertTrue(result);
    }

    /**
     *     1
     *   2    5
     * 3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testIsSameTree2() throws Exception {
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

        TreeNode bone = new TreeNode(1);
        TreeNode btwo = new TreeNode(2);
        TreeNode bthree = new TreeNode(3);
        bone.left = btwo;
        bone.right = five;
        btwo.left = bthree;

        SameTree st = new SameTree();
        boolean result = st.isSameTree(one, bone);
        Assert.assertFalse(result);
    }
}