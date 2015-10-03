package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/3/2015.
 */
public class FizzBuzzTest {

    @Test
    public void testFizzBuzz() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int fizzBuzzCount = fizzBuzz.fizzBuzz(15, "FizzBuzz");
        assertEquals(fizzBuzzCount, 1);
    }
}