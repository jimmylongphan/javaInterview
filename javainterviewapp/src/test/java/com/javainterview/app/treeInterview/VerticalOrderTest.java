package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/31/2016.
 */
public class VerticalOrderTest {

    @Test
    public void testVerticalOrder() throws Exception {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;
        nine.left = four;
        nine.right = five;
        twenty.left = two;
        twenty.right = seven;

        List<List<Integer>> result;
        VerticalOrder vo = new VerticalOrder();
        result = vo.verticalOrder(three);

        List<List<Integer>> expectedResult = new ArrayList<List<Integer>>();
        expectedResult.add(Arrays.asList(4));
        expectedResult.add(Arrays.asList(9));
        expectedResult.add(Arrays.asList(3, 5, 2));
        expectedResult.add(Arrays.asList(20));
        expectedResult.add(Arrays.asList(7));

        Assert.assertEquals(result, expectedResult);
    }
}