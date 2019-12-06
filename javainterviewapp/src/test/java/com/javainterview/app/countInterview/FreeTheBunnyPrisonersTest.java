package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static com.javainterview.app.countInterview.FreeTheBunnyPrisoners.solution;
import static org.testng.Assert.*;

/**
 * Created on 11/24/2019.
 */
public class FreeTheBunnyPrisonersTest {

    /**
     * Input:
     * Solution.solution(2, 1)
     * Output:
     *  [[0],
     *   [0]]
     */
    @Test
    public void testSolution() {
        int [][] result = solution(2, 1);
        int [][] expectedResult = {{0}, {0}};
        System.out.println("FreeTheBunnyPrisonersTest: " + result);
        assertEquals(result, expectedResult);
    }

    /**
     * Input:
     *   Solution.solution(4, 4)
     *
     * Output:
     *  [[0],
     *   [1],
     *   [2],
     *   [3]]
     */
    @Test
    public void testSolution2() {
        int [][] result = solution(4, 4);
        int [][] expectedResult = {{0}, {1}, {2}, {3}};
        System.out.println("FreeTheBunnyPrisonersTest: " + result);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testSolution3() {
        int[][] result = solution(5, 3);
        int[][] expectedResult = {{0, 1, 2, 3, 4, 5},
                {0, 1, 2, 6, 7, 8},
                {0, 3, 4, 6, 7, 9},
                {1, 3, 5, 6, 8, 9},
                {2, 4, 5, 7, 8, 9}};

        System.out.println("FreeTheBunnyPrisonersTest: " + result);
        assertEquals(result, expectedResult);
    }
}