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

        Node bone = new Node(1);
        Node btwo = new Node(2);
        Node bthree = new Node(3);
        bone.left = btwo;
        bone.right = five;
        btwo.left = bthree;

        SameTree st = new SameTree();
        boolean result = st.isSameTree(one, bone);
        Assert.assertFalse(result);
    }
}