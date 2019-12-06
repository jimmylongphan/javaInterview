package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2/17/2016.
 */
public class BigIntegerAddTest {

    @Test
    public void testAdd() throws Exception {
        int val1 = 1;
        int val2 = 2;

        BigIntegerAdd bi = new BigIntegerAdd();
        String result = bi.add(val1, val2);

        assertEquals(result, "3");
    }

    @Test
    public void testAddMax() throws Exception {
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;

        BigIntegerAdd bi = new BigIntegerAdd();
        String result = bi.add(val1, val2);

        assertEquals(result, "4,294,967,294");
    }
}