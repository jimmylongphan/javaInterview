package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 5/8/2016.
 */
public class MaxSubArrayLenTest {

    @Test
    public void testMaxSubArrayLen() throws Exception {
        int[] input = {-2, -1, 2, 1};

        MaxSubArrayLen m = new MaxSubArrayLen();
        int length = m.maxSubArrayLen(input, 1);
        Assert.assertEquals(length, 2);
    }
}