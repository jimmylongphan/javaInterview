package com.javainterview.app.MatrixInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/23/2019.
 */
public class BunnyEscapeTest {

    /**
     * Input:
     * Solution.solution({
     * {0, 1, 1, 0},
     * {0, 0, 0, 1},
     * {1, 1, 0, 0},
     * {1, 1, 1, 0}
     * })
     * Output: 7
     */
    @Test
    public void testSolution() {
        int[][] map = new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 7);
    }

    /**
     * Input:
     * Solution.solution(   {{0, 0, 0, 0, 0, 0},
     * {1, 1, 1, 1, 1, 0},
     * {0, 0, 0, 0, 0, 0},
     * {0, 1, 1, 1, 1, 1},
     * {0, 1, 1, 1, 1, 1},
     * {0, 0, 0, 0, 0, 0}})
     *
     * Output:
     * 11
     */
    @Test
    public void testSolution2() {
        int[][] map = new int[][]{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 11);
    }

    /**
     * Input:
     * Solution.solution({
     * {0, 1, 1, 0},
     * {0, 0, 0, 1},
     * {1, 1, 0, 0}
     * })
     * Output: 6
     */
    @Test
    public void testSolution3() {
        int[][] map = new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 6);
    }

    /**
     * Input:
     * Solution.solution({
     * {0, 1, 1},
     * {0, 0, 0},
     * {1, 1, 0}
     * })
     * Output: 5
     */
    @Test
    public void testSolution4() {
        int[][] map = new int[][]{{0, 1, 1}, {0, 0, 0}, {1, 1, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 5);
    }

    /**
     * Input:
     * Solution.solution({
     * {0, 0, 0, 0},
     * {0, 0, 0, 0},
     * {0, 0, 0, 0}
     * })
     * Output: 6
     */
    @Test
    public void testSolution5() {
        int[][] map = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 6);
    }

    /**
     * Input:
     * Solution.solution({
     * {0, 1, 1},
     * {0, 1, 0},
     * {1, 1, 0}
     * })
     * Output: 5
     */
    @Test
    public void testSolution6() {
        int[][] map = new int[][]{{0, 1, 1}, {0, 1, 0}, {1, 1, 0}};
        int length = BunnyEscape.solution(map);
        System.out.println("BunnyEscape length: " + length);
        assertEquals(length, 5);
    }
}