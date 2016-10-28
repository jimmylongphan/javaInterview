package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 4/16/2016.
 */
public class NextTreeNodeTest {

    @Test
    public void testConnect() throws Exception {
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
        three.left = six;
        three.right = seven;

        NextNode nn = new NextNode();
        nn.connect(one);

        Assert.assertEquals(two.next, three);
        Assert.assertEquals(five.next, six);
        Assert.assertEquals(six.next, seven);
    }

    @Test
    public void testConnectImperfect() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = seven;

        NextNode nn = new NextNode();
        nn.connectImperfect(one);

        Assert.assertEquals(two.next, three);
        Assert.assertEquals(five.next, seven);
    }
}