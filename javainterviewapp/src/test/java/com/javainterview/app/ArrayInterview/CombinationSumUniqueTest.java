package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 3/2/2016.
 */
public class CombinationSumUniqueTest {

    @Test
    public void testCombinationSum() throws Exception {
        int[] numbers = {10,1,2,7,6,1,5};

        CombinationSumUnique csu = new CombinationSumUnique();
        List<List<Integer>> results = csu.combinationSum(numbers, 8);

        List<List<Integer>> expectedResults = new ArrayList<List<Integer>>();
        expectedResults.add(Arrays.asList(1,1,6));
        expectedResults.add(Arrays.asList(1,2,5));
        expectedResults.add(Arrays.asList(1,7));
        expectedResults.add(Arrays.asList(2,6));

        Assert.assertEquals(results, expectedResults);
    }

    @Test
    public void testCombinationSum2() throws Exception {
        int[] numbers = {10,2,5};

        CombinationSumUnique csu = new CombinationSumUnique();
        List<List<Integer>> results = csu.combinationSum(numbers, 12);

        List<List<Integer>> expectedResults = new ArrayList<List<Integer>>();
        expectedResults.add(Arrays.asList(2,10));

        Assert.assertEquals(results, expectedResults);
    }
}