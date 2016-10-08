package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

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
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

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