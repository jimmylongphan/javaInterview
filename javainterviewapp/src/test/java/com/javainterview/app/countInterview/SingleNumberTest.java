package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}