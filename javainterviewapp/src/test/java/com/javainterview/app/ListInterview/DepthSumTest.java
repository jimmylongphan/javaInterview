package com.javainterview.app.ListInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 4/10/2016.
 */
public class DepthSumTest {

    @Test
    public void testDepthSum() throws Exception {
        DepthSum ds = new DepthSum();
        List<NestedInteger> input = new ArrayList<NestedInteger>();

        // first element is a list of NestedIntegers
        // Each element is a NestedInteger of size 1
        List<NestedInteger> ni1List = new LinkedList<NestedInteger>();
        ni1List.add(new NestedInteger(1));
        ni1List.add(new NestedInteger(1));
        NestedInteger ni1 = new NestedInteger(ni1List);
        input.add(ni1);

        // add the 2
        input.add(new NestedInteger(2));

        // second element is a list of NestedIntegers
        // Each element is a NestedInteger of size 1
        List<NestedInteger> ni2List = new LinkedList<NestedInteger>();
        ni2List.add(new NestedInteger(1));
        ni2List.add(new NestedInteger(1));
        NestedInteger ni2 = new NestedInteger(ni2List);
        input.add(ni2);

        int expectedResult = 10;
        int result = ds.depthSum(input);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testDepthSum2() throws Exception {
        DepthSum ds = new DepthSum();
        List<NestedInteger> input = new ArrayList<NestedInteger>();

        input.add(new NestedInteger(1));

        // first element is a list of NestedIntegers
        // Each element is a NestedInteger of size 1
        List<NestedInteger> ni1List = new LinkedList<NestedInteger>();
        ni1List.add(new NestedInteger(4));

        List<NestedInteger> ni2List = new LinkedList<NestedInteger>();
        ni2List.add(new NestedInteger(6));
        NestedInteger ni2 = new NestedInteger(ni2List);
        ni1List.add(ni2);

        NestedInteger ni1 = new NestedInteger(ni1List);
        input.add(ni1);

        int expectedResult = 27;
        int result = ds.depthSum(input);
        Assert.assertEquals(result, expectedResult);
    }
}