package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created on 2/29/2016.
 */
public class PermutationsTest {

    @Test
    public void testGetPermutations() throws Exception {
        String test = "ab";
        Permutations p = new Permutations();
        List<String> results =  p.permuteString(test);

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("ab");
        expectedResults.add("ba");

        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void testGetPermutations2() throws Exception {

        String test = "abc";
        Permutations p = new Permutations();
        List<String> results =  p.permuteString(test);

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("abc");
        expectedResults.add("bac");
        expectedResults.add("bca");
        expectedResults.add("acb");
        expectedResults.add("cab");
        expectedResults.add("cba");

        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void testPermuteNum() throws Exception {
        int[] num = {1, 2};

        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(num);

        List<List<Integer>> expectedResults = new ArrayList<List<Integer>>();
        expectedResults.add(Arrays.asList(1,2));
        expectedResults.add(Arrays.asList(2,1));

        Assert.assertEquals(expectedResults, result);
    }
}