package com.javainterview.app.ArrayInterview;


import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(numbers, expected);
    }
}