package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/2/2016.
 */
public class CombinationSumDuplicatesTest {

    @Test
    public void testCombinationSum() throws Exception {
        int[] numbers = {2,3,6,7};

        CombinationSumDuplicates cs = new CombinationSumDuplicates();
        List<List<Integer>> result = cs.combinationSum(numbers, 7);

        List<List<Integer>> expectedResults = new ArrayList<List<Integer>>();
        expectedResults.add(Arrays.asList(2, 2, 3));
        expectedResults.add(Arrays.asList(7));

        Assert.assertEquals(result, expectedResults);
    }
}