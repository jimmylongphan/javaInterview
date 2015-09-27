package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class ArraySubsetTest {

    @Test
    public void testIsSubset() throws Exception {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6, 1, 2, 3};

        ArraySubset arraySubset = new ArraySubset();
        assertTrue(arraySubset.isSubset(a1, a2));
    }

    @Test
    public void testIsSubset2() throws Exception {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};

        ArraySubset arraySubset = new ArraySubset();
        assertFalse(arraySubset.isSubset(a1, a2));
    }

    @Test
    public void testIsSubset3() throws Exception {
        int[] a1 = {1, 2, 3, 1, 2, 3};
        int[] a2 = {1, 1, 2, 2, 3, 3, 4, 5, 6};

        ArraySubset arraySubset = new ArraySubset();
        assertTrue(arraySubset.isSubset(a1, a2));
    }
}