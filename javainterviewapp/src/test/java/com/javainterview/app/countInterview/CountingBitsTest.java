package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/20/2016.
 */
public class CountingBitsTest {

    @Test
    public void testCountBits() throws Exception {
        int num = 5;
        int[] expected = {0, 1, 1, 2, 1, 2};

        CountingBits cb = new CountingBits();
        int[] result = cb.countBits(num);
        Assert.assertEquals(result, expected);
    }
}