package com.javainterview.app.MatrixInterview;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class WaterFlowTest {

    @Test
    public void testFindMountain() throws Exception {
        // create matrix
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };

        WaterFlow waterFlow = new WaterFlow();
        List<Point> mountain = waterFlow.findMountain(matrix);

        // check the order
        // if order becomes different, then sort both results
        List<Point> expectedMountain = Arrays.asList(
                new Point(2, 2),
                new Point(1, 4),
                new Point(3, 0),
                new Point(1, 3),
                new Point(4, 0),
                new Point(0, 4),
                new Point(3, 1)
        );

        assertEquals(mountain, expectedMountain);
    }
}