package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/28/2015.
 */
public class RotatedArrayTest {

    @Test
    public void testSearch() throws Exception {
        int nums[] = {0, 1, 2, 4, 5, 6, 7,};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.search(nums, 5);
        assertEquals(index, 4);
    }

    @Test
    public void testSearch2() throws Exception {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.search(nums, 5);
        assertEquals(index, 1);
    }

    @Test
    public void testSearch3() throws Exception {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.search(nums, 2);
        assertEquals(index, 6);
    }
}