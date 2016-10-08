package com.javainterview.app.treeInterview;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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

        DepthFirstSearch dfs = new DepthFirstSearch();
        List<String> actual = dfs.findPath(one, seven);
        List<String> solution = Arrays.asList("1", "5", "7");
        Assert.assertEquals(actual, solution);
    }
}