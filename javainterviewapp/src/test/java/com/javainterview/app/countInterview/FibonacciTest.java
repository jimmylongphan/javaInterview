package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/2/2015.
 */
public class FibonacciTest {

    @Test
    public void testFibonacciRecursive() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        int val = fibonacci.fibonacciRecursive(30);

        assertEquals(val, 832040);
    }

    @Test
    public void testFibonacciIterative() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        int val = fibonacci.fibonacciIterative(30);

        assertEquals(val, 832040);
    }

    @Test
    public void testFibonacciPrecompute() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        int val = fibonacci.fibonacciPrecompute(30);

        assertEquals(val, 832040);
    }
}