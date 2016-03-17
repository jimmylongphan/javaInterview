package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class AddDigitsTest {

    @Test
    public void testAddDigits() throws Exception {
        int num = 38;
        AddDigits ad = new AddDigits();
        int result = ad.addDigits(num);

        Assert.assertEquals(result, 2);
    }

    @Test
    public void testAddDigitsLoop() throws Exception {
        int num = 38;
        AddDigits ad = new AddDigits();
        int result = ad.addDigitsLoop(num);

        Assert.assertEquals(result, 2);
    }

    @Test
    public void testAddDigitsLoop2() throws Exception {
        int num = 123;
        AddDigits ad = new AddDigits();
        int result = ad.addDigitsLoop(num);
        int result2 = ad.addDigits(num);

        Assert.assertEquals(result, result2);
    }
}