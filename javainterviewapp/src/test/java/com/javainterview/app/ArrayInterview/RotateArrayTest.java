package com.javainterview.app.ArrayInterview;

import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/20/2016.
 */
public class RotateArrayTest {

    @Test
    public void testRotate() throws Exception {
        int[] nums = {1, 2};
        int[] expected = {1, 2};

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 0);
        Assert.assertArrayEquals(nums, expected);
    }

    @Test
    public void testRotate1() throws Exception {
        int[] nums = {1, 2};
        int[] expected = {2, 1};

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 1);
        Assert.assertArrayEquals(nums, expected);
    }
}