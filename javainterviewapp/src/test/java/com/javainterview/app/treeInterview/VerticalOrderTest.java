package com.javainterview.app.treeInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class VerticalOrderTest {

    @Test
    public void testVerticalOrder() throws Exception {
        Node three = new Node(3);
        Node nine = new Node(9);
        Node twenty = new Node(20);
        Node four = new Node(4);
        Node five = new Node(5);
        Node two = new Node(2);
        Node seven = new Node(7);

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