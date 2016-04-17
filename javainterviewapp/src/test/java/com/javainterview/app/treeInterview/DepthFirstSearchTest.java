package com.javainterview.app.treeInterview;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 2/21/2016.
 */
public class DepthFirstSearchTest {

    /**
     *           1
     *        2    5
     *      3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testDfs() throws Exception {
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

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(one);
    }

    /**
     *           1
     *        2    5
     *      3  4  6  7
     *
     * @throws Exception
     */
    @Test
    public void testDfsPath() throws Exception {
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

        DepthFirstSearch dfs = new DepthFirstSearch();
        List<String> actual = dfs.findPath(one, seven);
        List<String> solution = Arrays.asList("1", "5", "7");
        Assert.assertEquals(actual, solution);
    }
}