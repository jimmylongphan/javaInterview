package com.javainterview.app.ArrayInterview;

import com.javainterview.app.treeInterview.InvertTree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 4/3/2016.
 */
public class KSumTest {

    @Test
    public void testKSum() throws Exception {
        int[] numbers = {-2, 1, 5};

        KSum kSum = new KSum();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        List<List<Integer>> expectedResult = new LinkedList<List<Integer>>();
        expectedResult.add(Arrays.asList(-2, 1));

        result = kSum.kSum(numbers, 2, -1);
        Assert.assertEquals(result, expectedResult);
    }
}