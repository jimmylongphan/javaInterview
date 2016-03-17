package com.javainterview.app.ArrayInterview;

import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class MoveZeroesTest {

    @Test
    public void testMoveZeroes() throws Exception {
        int numbers[] = {9, 0, 7, 2, 0, 2, 4};

        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(numbers);

        int expected[] = {9, 7, 2, 2, 4, 0, 0};
        Assert.assertArrayEquals(expected, numbers);
    }
}