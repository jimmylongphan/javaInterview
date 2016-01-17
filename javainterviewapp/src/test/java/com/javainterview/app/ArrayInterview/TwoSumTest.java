package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 1/16/2016.
 */
public class TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        int numbers[] = new int[]{2,7,11,15};

        TwoSum twoSum = new TwoSum();
        Integer[] result = twoSum.twoSum(numbers, 9);
        assertEquals(result[0].intValue(), 1);
        assertEquals(result[1].intValue(), 2);
    }
}