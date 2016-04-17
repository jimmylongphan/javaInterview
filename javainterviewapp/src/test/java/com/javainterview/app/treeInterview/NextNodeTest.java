package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 4/16/2016.
 */
public class NextNodeTest {

    @Test
    public void testConnect() throws Exception {
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
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);

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