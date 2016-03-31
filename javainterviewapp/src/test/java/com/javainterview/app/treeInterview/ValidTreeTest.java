package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class ValidTreeTest {
    /**
     * @throws Exception
     */
    @Test
    public void testValidTree() throws Exception {

        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};

        ValidTree vt = new ValidTree();
        boolean result = vt.validTree(5, edges);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidTree2() throws Exception {

        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        ValidTree vt = new ValidTree();
        boolean result = vt.validTree(5, edges);
        Assert.assertFalse(result);
    }
}