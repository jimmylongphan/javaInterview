package com.javainterview.app.BackTrackingInterview;

import org.testng.annotations.Test;

/**
 * Created on 11/22/2019.
 */
public class BunnyCodeTest {

    /**
     * Input:
     * solution.solution({3, 1, 4, 1})
     * Output:
     *     4311
     */
    @Test
    public void testSolution() {
        int[] input = {3, 1, 4, 1};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

    /**
     * Input:
     * Solution.solution({3, 1, 4, 1, 5, 9})
     * Output:
     *      94311
     */
    @Test
    public void testSolution2() {
        int[] input = {3, 1, 4, 1, 5, 9};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

    /**
     * {1, 1, 6}
     */
    @Test
    public void testSolution3() {
        int[] input = {1, 1, 6};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

    /**
     * {1, 1, 1, 5}
     */
    @Test
    public void testSolution4() {
        int[] input = {1, 1, 1, 5};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

    /**
     * {1, 1, 1, 1, 5}
     */
    @Test
    public void testSolution5() {
        int[] input = {1, 1, 1, 1, 5};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

    /**
     * {1, 1, 1, 1, 5}
     */
    @Test
    public void testSolution6() {
        int[] input = {1, 1, 1, 1, 6};

        BunnyCode bunnyCode = new BunnyCode();
        int max = BunnyCode.solution(input);
        System.out.println("max is " + max);
    }

}