package com.javainterview.app.ListInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 4/11/2016.
 */
public class NestedIteratorTest {

    @Test
    public void testNext() throws Exception {
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

        List<Integer> expectedResult = Arrays.asList(1, 1, 2, 1, 1);

        NestedIterator ni = new NestedIterator(input);
        for (Integer value : expectedResult) {
            Integer current = ni.next();
            Assert.assertEquals(current, value);
        }
    }

    @Test
    public void testNext2() throws Exception {
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

        List<Integer> expectedResult = Arrays.asList(1, 4, 6);

        NestedIterator ni = new NestedIterator(input);
        for (Integer value : expectedResult) {
            Integer current = ni.next();
            Assert.assertEquals(current, value);
        }
    }

}