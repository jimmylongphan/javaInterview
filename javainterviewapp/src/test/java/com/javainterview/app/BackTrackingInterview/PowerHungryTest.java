package com.javainterview.app.BackTrackingInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/22/2019.
 */
public class PowerHungryTest {

    @Test
    public void testSolution() {
        int[] input = {2, 0, 2, 2, 0};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "8");
    }

    @Test
    public void testSolution2() {
        int[] input = {-2, -3, 4, -5};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "60");
    }

    @Test
    public void testSolution3() {
        int[] input = {1,2,3,4,5};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "120");
    }

    @Test
    public void testSolution4() {
        int[] input = {1,2};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "2");
    }

    @Test
    public void testSolution5() {
        int[] input = {1,-2};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "1");
    }

    @Test
    public void testSolution6() {
        int[] input = {-1,-2};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "2");
    }

    @Test
    public void testSolution7() {
        int[] input = {};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "0");
    }

    @Test
    public void testSolution8() {
        int[] input = {2};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "2");
    }

    @Test
    public void testSolution9() {
        int[] input = {2, 0};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "2");
    }

    @Test
    public void testSolution11() {
        int[] input = {-1};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "-1");
    }

    @Test
    public void testSolution12() {
        int[] input = {-5, -3, -2, -7, -10};

        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "1050");
    }

    @Test
    public void testSolution13() {
        int[] input = {-2, 0, 0};
        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "0");
    }

    @Test
    public void testSolution14() {
        int[] input = {-2, 0, 3, 4};
        String result = PowerHungry.solution(input);
        System.out.println(result);
        assertEquals(result, "12");
    }

}