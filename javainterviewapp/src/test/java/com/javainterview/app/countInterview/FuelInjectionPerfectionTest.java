package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/24/2019.
 */
public class FuelInjectionPerfectionTest {
    /**
     * Solution.solution('4')
     * Output:
     * 2
     */
    @Test
    public void testSolution() {
        int result = FuelInjectionPerfection.solution("4");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 2);
    }

    /**
     * Input:
     * Solution.solution('15')
     * Output:
     * 5
     */
    @Test
    public void testSolution2() {
        int result = FuelInjectionPerfection.solution("15");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 5);
    }

    /**
     * 8
     * 8 -> 4 -> 2 -> 1
     */
    @Test
    public void testSolution3() {
        int result = FuelInjectionPerfection.solution("8");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 3);
    }

    /**
     * 4000 -> 2000 -> 1000 -> 500 -> 250 -> 125 -> 126 -> 127 -> 128 ->
     * 64 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1
     *
     * 15
     */
    @Test
    public void testSolution4() {
        int result = FuelInjectionPerfection.solution("4000");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 14);
    }

    /**
     * 0   1  2   3  4,  5,  6,  7,  8,   9,   10,   11,   12
     * 1 , 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2056, 4096
     *
     * 3000 - 2056 = 944  -> 11
     * 944 - 512 = 432 -> 9
     * 432 - 256 = 176 -> 8
     * 176 - 128 = 48 -> 7
     * 48 - 32 = 16 -> 5
     * 16 = 1 -> 4
     *
     * 44 steps????
     *
     * 3000 -> 1500 -> 750 -> 375 -> 374 -> 187 -> 186 -> 93
     * -> 92 -> 46 -> 23 -> 22 -> 11 -> 10 -> 5 -> 4 -> 2 -> 1
     *
     */
    @Test
    public void testSolution5() {
        int result = FuelInjectionPerfection.solution("3000");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 14);
    }

    @Test
    public void testSolution6() {
        int result = FuelInjectionPerfection.solution("5");
        System.out.println("FuelInjectionPerfection count: " + result);
        assertEquals(result, 3);
    }

    /**
     * 19
     *
     * option 1
     * 1 -> 2 -> 4 -> 16 -> 32
     * 19 - 16 = 3
     * 3 + 3 = 6
     *
     * option 2
     * 19 -> 18 -> 9 -> 8 -> 4 -> 2 -> 1
     * 6
     *
     * option 3
     * 19 -> 20 -> 10 -> 5 -> 4 -> 2 -> 1
     *
     *

     */


}