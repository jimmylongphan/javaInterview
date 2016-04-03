package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 4/3/2016.
 */
public class ThreeSumTest {

    @Test
    public void testThreeSum() throws Exception {
        int[] numbers = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expectedResult = new LinkedList<List<Integer>>();
        expectedResult.add(Arrays.asList(-1,-1,2));
        expectedResult.add(Arrays.asList(-1,0,1));

        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum(numbers, 0);
        Assert.assertEquals(result, expectedResult);
    }
}