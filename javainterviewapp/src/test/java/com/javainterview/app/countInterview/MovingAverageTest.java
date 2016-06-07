package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 6/6/2016.
 */
public class MovingAverageTest {

    @Test
    public void testNext() throws Exception {
        MovingAverage m = new MovingAverage(3);
        double result = m.next(1);
        Assert.assertEquals(1.0, result);

        result = m.next(10);
        Assert.assertEquals(result, (1 + 10) / 2.0);

        result = m.next(3);
        Assert.assertEquals(result, (1 + 10 + 3) / 3.0);

        result = m.next(5);
        Assert.assertEquals(result, (10 + 3 + 5) / 3.0);
    }
}