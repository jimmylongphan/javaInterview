package com.javainterview.app.MatrixInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class WallsAndGatesTest {

    @Test
    public void testWallsAndGates() throws Exception {
        int[][] rooms = new int[][]{
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        int[][] expectedResult = new int[][]{
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}};

        WallsAndGates wg = new WallsAndGates();
        wg.wallsAndGates(rooms);
        Assert.assertEquals(rooms, expectedResult);
    }
}