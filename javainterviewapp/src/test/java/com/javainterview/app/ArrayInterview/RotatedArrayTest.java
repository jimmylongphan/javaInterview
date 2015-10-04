package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/28/2015.
 */
public class RotatedArrayTest {

    @Test
    public void testSearch() throws Exception {
        int nums[] = {0, 1, 2, 4, 5, 6, 7};

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

    @Test
    public void testInsert() throws Exception {
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.findPositionToInsert(nums, 5);
        assertEquals(index, 5);
    }

    @Test
    public void testInsert2() throws Exception {
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7};

        RotatedArray rotatedArray = new RotatedArray();

        int index = rotatedArray.findPositionToInsert(nums, 8);
        assertEquals(index, 8);
    }

    @Test
    public void testInsert3() throws Exception {
        int nums[] = {4, 5, 6, 7, 0, 1, 2, 3};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.findPositionToInsert(nums, 5);
        assertEquals(index, 1);
    }

    @Test
    public void testInsert4() throws Exception {
        int nums[] = {4, 5, 6, 10, 0, 1, 2, 3};

        RotatedArray rotatedArray = new RotatedArray();
        int index = rotatedArray.findPositionToInsert(nums, 9);
        assertEquals(index, 3);
    }

}