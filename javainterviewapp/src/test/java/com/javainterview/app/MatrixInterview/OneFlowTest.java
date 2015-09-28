package com.javainterview.app.MatrixInterview;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class OneFlowTest {

    @Test
    public void testFindPathExists() throws Exception {
        // create matrix
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1},
        };

        OneFlow oneFlow = new OneFlow();

        // counter intuitive
        // row 1, column 0
        Point start = new Point(1, 0);

        boolean foundPath = oneFlow.findPathExists(start, matrix);
        assertTrue(foundPath);
    }

    @Test
    public void testFindPathExists2() throws Exception {
        // create matrix
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
        };

        OneFlow oneFlow = new OneFlow();

        // counter intuitive
        // row 1, column 0
        Point start = new Point(1, 0);

        boolean foundPath = oneFlow.findPathExists(start, matrix);
        assertFalse(foundPath);
    }

    @Test
    public void testFindPathExists3() throws Exception {
        // create matrix
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
        };

        OneFlow oneFlow = new OneFlow();

        // counter intuitive
        // row 1, column 0
        Point start = new Point(3, 0);

        boolean foundPath = oneFlow.findPathExists(start, matrix);
        assertTrue(foundPath);
    }

    @Test
    public void testFindPath() throws Exception {
        // create matrix
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1},
        };

        OneFlow oneFlow = new OneFlow();

        // counter intuitive
        // row 1, column 0
        Point start = new Point(1, 0);

        List<Point> points = oneFlow.findPath(start, matrix);

        List<Point> expectedPoints = Arrays.asList(
                new Point(1, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(4, 2),
                new Point(4, 3),
                new Point(4, 4)
        );

        assertEquals(points, expectedPoints);
    }

}