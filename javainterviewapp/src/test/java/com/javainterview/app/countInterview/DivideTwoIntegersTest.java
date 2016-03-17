package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class DivideTwoIntegersTest {

    @Test
    public void testDivide() throws Exception {
        DivideTwoIntegers dti = new DivideTwoIntegers();

        int result = dti.divide(17, 2);
        Assert.assertEquals(result, 8);
    }

    @Test
    public void testDivide2() throws Exception {
        DivideTwoIntegers dti = new DivideTwoIntegers();

        int result = dti.divide(16, -3);
        Assert.assertEquals(result, -5);
    }
}