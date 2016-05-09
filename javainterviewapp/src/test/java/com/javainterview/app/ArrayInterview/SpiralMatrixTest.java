package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 5/8/2016.
 */
public class SpiralMatrixTest {

    @Test
    public void testSpiralOrder() throws Exception {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expectedarray = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        List<Integer> expectedResult = new ArrayList<Integer>();
        for( int i : expectedarray ) {
            expectedResult.add(i);
        }

        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(matrix);

        Assert.assertEquals(expectedResult, expectedResult);
    }
}