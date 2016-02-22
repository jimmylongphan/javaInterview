package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 2/21/2016.
 */
public class BreadthFirstSearchTest {

    /**
     *      1
     *   2      3
     *  4 5   6
     *
     * @throws Exception
     */
    @Test
    public void testBfs() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.bfs(one);
    }

    /**
     *      1
     *   2      3
     *  4 5   6
     *          7
     *
     * @throws Exception
     */
    @Test
    public void testBfsFind1() throws Exception {
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
        six.right = seven;

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        List<String> actual = bfs.shortestPath(one, seven);
        List<String> solution = Arrays.asList("1", "3", "6", "7");
        Assert.assertEquals(actual, solution);
    }

    /**
     *      1
     *   2      3
     *  4 5   6
     *
     * @throws Exception
     */
    @Test
    public void testBfsFind2() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        List<String> actual = bfs.shortestPath(one, five);
        List<String> solution = Arrays.asList("1", "2", "5");
        Assert.assertEquals(actual, solution);
    }
}