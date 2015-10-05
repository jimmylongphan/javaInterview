package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 10/5/2015.
 */
public class FourSumTest {

    @Test
    public void testFindFourSum() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;

        FourSum fourSum = new FourSum();
        List<Integer> good = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>();
        expectedAnswer.add(good);

        List<List<Integer>> solution = fourSum.findFourSum(nums, target);
        assertEquals(solution, expectedAnswer);
    }

    @Test
    public void testFindFourSum2() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 30;

        FourSum fourSum = new FourSum();
        List<Integer> good = Arrays.asList(6, 7, 8, 9);
        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>();
        expectedAnswer.add(good);

        List<List<Integer>> solution = fourSum.findFourSum(nums, target);
        assertEquals(solution, expectedAnswer);
    }
}