package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/20/2016.
 */
public class ProductArrayTest {

    @Test
    public void testProductArray() throws Exception {
        int[] test = {1, 2, 3, 4};
        int[] expectedResult = {24, 12, 8, 6};

        ProductArray pa = new ProductArray();
        int[] result = pa.productExceptSelf(test);
        Assert.assertEquals(result, expectedResult);
    }
}