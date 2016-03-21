package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class SingleNumberTest {

    @Test
    public void testSingleNumber() throws Exception {
        int[] numbers = {0, 0, 1, 1, 2, 2, 3};

        SingleNumber sn = new SingleNumber();
        int result = sn.singleNumber(numbers);

        Assert.assertEquals(result, 3);
    }

    @Test
    public void testDoubleNumber() throws Exception {
        // 0011 -> 3
        // 0101 -> 5
        // 0110 -> 6
        int[] numbers = {0, 0, 1, 1, 2, 2, 3, 5};

        SingleNumber sn = new SingleNumber();
        int[] result = sn.doubleNumber(numbers);
        int[] expectedResult = {3, 5};

        Assert.assertEquals(result, expectedResult);
    }
}