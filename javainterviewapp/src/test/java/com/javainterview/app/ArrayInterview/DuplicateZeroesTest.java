package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 12/6/2019.
 */
public class DuplicateZeroesTest {

    @Test
    public void testDuplicateZeros() {
        int[] input = new int[]{1,0,2,3,0,4,5,0};
        DuplicateZeroes dz = new DuplicateZeroes();
        dz.duplicateZeros(input);
        int[] expected = {1,0,0,2,3,0,0,4};
        assertEquals(input, expected);
    }
}