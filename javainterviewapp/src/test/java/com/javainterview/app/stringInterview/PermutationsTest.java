package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created on 2/29/2016.
 */
public class PermutationsTest {

    @Test
    public void testGetPermutations() throws Exception {
        String test = "ab";
        Permutations p = new Permutations();
        List<String> results =  p.getPermutations(test);

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("ab");
        expectedResults.add("ba");

        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void testGetPermutations2() throws Exception {

        String test = "abc";
        Permutations p = new Permutations();
        List<String> results =  p.getPermutations(test);

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("abc");
        expectedResults.add("bac");
        expectedResults.add("bca");
        expectedResults.add("acb");
        expectedResults.add("cab");
        expectedResults.add("cba");

        Assert.assertEquals(expectedResults, results);
    }
}