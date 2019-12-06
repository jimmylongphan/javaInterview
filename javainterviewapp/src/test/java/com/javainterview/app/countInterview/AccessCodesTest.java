package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/24/2019.
 */
public class AccessCodesTest {

    @Test
    public void testSolution() {
        int[] input = new int[]{1, 1, 1};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 1);
    }

    @Test
    public void testSolution2() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 3);
    }

    @Test
    public void testSolution3() {
        int[] input = new int[]{1, 2, 4, 8};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 4);
    }

    @Test
    public void testSolution4() {
        int[] input = new int[]{1, 1, 1, 2};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 4);
    }

    @Test
    public void testSolution5() {
        int[] input = new int[]{3, 7, 10};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 0);
    }

    @Test
    public void testSolution6() {
        int[] input = new int[]{1,1,1,2,2};

        int numCodes = AccessCodes.solution(input);
        System.out.println("Access Codes count is: " + numCodes);
        assertEquals(numCodes, 10);
    }
}